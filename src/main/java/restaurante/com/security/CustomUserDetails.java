package restaurante.com.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import restaurante.com.model.Usuario;

@Getter
public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private final Usuario usuario;

	    public CustomUserDetails(Usuario usuario) {
	        this.usuario = usuario;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return usuario.getRoles().stream()
	                .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getNombre()))
	                .collect(Collectors.toSet());
	    }

	    @Override
	    public String getPassword() {
	        return usuario.getPassword();
	    }

	    @Override
	    public String getUsername() {
	        return usuario.getUsername();
	    }

	    @Override public boolean isAccountNonExpired() { return true; }
	    @Override public boolean isAccountNonLocked() { return true; }
	    @Override public boolean isCredentialsNonExpired() { return true; }
	    @Override public boolean isEnabled() { return true; }

}
