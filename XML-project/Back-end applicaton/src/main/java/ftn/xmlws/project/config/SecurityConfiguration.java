//package ftn.xmlws.project.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import ftn.xmlws.project.security.jwt.JWTFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Bean
//	public JWTFilter authenticationTokenFilterBean() throws Exception {
//		JWTFilter authenticationTokenFilter = new JWTFilter();
//		authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
//		return authenticationTokenFilter;
//	}
//
//	@Autowired
//	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//
//		authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and()
//		.authorizeRequests()
//		.antMatchers("/api/auth/**").permitAll()
//		.and()
//		.csrf().disable()
//		.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));;
//		
//		
//
//		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
//	}
//	
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//            .antMatchers(HttpMethod.OPTIONS, "/**");
//        
//
//    }
//
//
//}
