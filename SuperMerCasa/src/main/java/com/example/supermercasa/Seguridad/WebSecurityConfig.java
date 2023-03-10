package com.example.supermercasa.Seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	RepositoryUserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	// Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/registro").permitAll();
        http.authorizeRequests().antMatchers("/registroLogin").permitAll();
        http.authorizeRequests().antMatchers("/categorias").permitAll();
        http.authorizeRequests().antMatchers("/ofertas").permitAll();
        http.authorizeRequests().antMatchers("/producto/*").permitAll();
        http.authorizeRequests().antMatchers("/atencionalcliente").permitAll();
        http.authorizeRequests().antMatchers("/centros").permitAll();
        http.authorizeRequests().antMatchers("/contacto").permitAll();


        // Private pages
        http.authorizeRequests().antMatchers("/carrito").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/addProducto/*").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/addSeguimiento").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/historial").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/seguimientoPedido/*").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/perfilusuario").hasAnyRole("USER");

        // Admin pages
        http.authorizeRequests().antMatchers("/nuevoProducto").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/eliminarProducto").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/modificarProducto").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/verCategorias").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/addCategorias").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/eliminarCategorias").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/administrarProductos").hasAnyRole("ADMIN");

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/loginSuccess");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
    }
}
