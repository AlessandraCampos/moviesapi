package moviesapi.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import moviesapi.Services.AutenticacaoService;
import moviesapi.Services.UsuarioService;

@EnableWebSecurity // Habilita Segurança na aplicação
@Configuration // Informa ao Spring que é uma configuração
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// source/ override implement methods - 3 configure para sobrescrever

	@Autowired
	private UsuarioService usuarioService;
	@Lazy // Anotação circular
	@Autowired
	private AutenticacaoService autenticacaoService;

	@Bean
	@Lazy // Anotação circular
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {

		web.ignoring().antMatchers("/v3/api-docs", "/configuration/ui", "/swagger-resources/**",
				"/configuration/security", "/swagger-ui.html", "/webjars/**","/h2-console/**");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers(HttpMethod.POST, "/auth").permitAll()
				.antMatchers(HttpMethod.GET, "/filmes").permitAll().antMatchers(HttpMethod.GET, "/swagger-ui/*")
				.permitAll().anyRequest().authenticated().and()
				.authorizeRequests().antMatchers("/h2-console/**").permitAll()
		        .and().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(new FiltroAutenticacao(autenticacaoService, usuarioService),
						UsernamePasswordAuthenticationFilter.class);

	}

}
