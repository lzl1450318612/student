package com.xiongantaoli.grade.security.auth;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.code.kaptcha.Constants;
import com.xiongantaoli.grade.entity.SysResource;
import com.xiongantaoli.grade.entity.SysRoleResources;
import com.xiongantaoli.grade.entity.SysUser;
import com.xiongantaoli.grade.entity.SysUserRoles;
import com.xiongantaoli.grade.mapper.SysResourceMapper;
import com.xiongantaoli.grade.mapper.SysRoleResourcesMapper;
import com.xiongantaoli.grade.mapper.SysUserMapper;
import com.xiongantaoli.grade.mapper.SysUserRolesMapper;
/**
 * 自定义校验方式
 * @author 王震
 *
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
	private final String VALIDATECODE_ERROR = "validatecode_error";//session存储验证码是否错误的key值
//	@Value("${application.messsage.error.validatecode:验证码错误}")
//	private String validatecodeErrorMessage = "验证码错误";
//	@Value("${application.messsage.error.validatecode.overtime:验证码超时}")
//	private String validatecodeOverTimeErrorMessage = "验证码超时";
	@Value("${application.messsage.error.username:wrong username}")
	private String usernameErrorMessage = "wrong username";
	@Value("${application.messsage.error.password:wrong password}")
	private String passwordErrorMessage = "wrong password";
	@Value("${application.messsage.error.available:Account is not enabled}")
	private String availableErrorMessage = "Account is not enabled";
	
	@Autowired
	private SysUserMapper userMapper;

	@Autowired
	private SysUserRolesMapper userRolesMapper;
	
	@Autowired
	private SysRoleResourcesMapper roleResourcesMapper;
	
	@Autowired
	private SysResourceMapper resourceMapper;
	
	@Autowired
	private HttpSession session;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
        String password = authentication.getCredentials().toString();
//        CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();  // 如上面的介绍，这里通过authentication.getDetails()获取详细信息
//        String checkCode = details.getValidateCode();
//        Object cko = session.getAttribute(Constants.KAPTCHA_SESSION_KEY) ; //验证码对象
        
//        if(cko == null){
//        	throw new BadCredentialsException("验证码已失效，请重新输入！");
//        }
//        String captcha = cko.toString();
//        Date now = new Date();
//        Long codeTime = Long.valueOf(session.getAttribute(Constants.KAPTCHA_SESSION_DATE)+"");
//        session.removeAttribute(VALIDATECODE_ERROR);
//        if(StringUtils.isEmpty(checkCode) || captcha == null ||  !(checkCode.equalsIgnoreCase(captcha))) {
//        	session.setAttribute(VALIDATECODE_ERROR, this.validatecodeErrorMessage);
//        	throw new BadCredentialsException("验证码错误！");
//        } else if ((now.getTime()-codeTime)/1000/60>5) {
//        	session.setAttribute(VALIDATECODE_ERROR, this.validatecodeOverTimeErrorMessage);
//            //验证码有效时长为5分钟
//        	throw new BadCredentialsException("验证码已失效，请重新输入！");
//        }else {
//            session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
//            session.removeAttribute(Constants.KAPTCHA_SESSION_DATE);
//        }
        
        SysUser user =  new SysUser();
        user.setUsername(username);
        List<SysUser> users = userMapper.selectByUser(user);
        if(users.size() > 0) {
        	user = users.get(0);
        }else {
        	user = null;
        }
        
        if(user == null){
        	session.setAttribute(VALIDATECODE_ERROR, this.usernameErrorMessage);
            throw new BadCredentialsException("Username not found.");
        }
        if(!user.getAvailable()) {
        	session.setAttribute(VALIDATECODE_ERROR, this.availableErrorMessage);
        	throw new BadCredentialsException("Account is not enabled");
        }
        if(!BCrypt.checkpw(password, user.getPassword())){
        	session.setAttribute(VALIDATECODE_ERROR, this.passwordErrorMessage);
        	throw new BadCredentialsException("wrong password");
        }
        
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
       
		List<SysUserRoles> userRoles = userRolesMapper.selectByUserId(user.getId());
		
		for(SysUserRoles role : userRoles){
			List<SysRoleResources> roleResourcesList = roleResourcesMapper.selectByRoleId(role.getRolesId());
			for(SysRoleResources roleResources : roleResourcesList){
				SysResource resource = resourceMapper.selectByPrimaryKey(roleResources.getResourcesId());
				if(resource != null ){
					if(resource.getPermission() != null && !"".equals(resource.getPermission())){
						auths.add(new SimpleGrantedAuthority(resource.getPermission()));//将用户的角色名作为权限
					}
				}
			}
		}
		
        return new UsernamePasswordAuthenticationToken(user, password, auths);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
