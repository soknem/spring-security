package co.istad.springsecuritybasic.repository;

import co.istad.springsecuritybasic.model.Authority;
import co.istad.springsecuritybasic.model.Role;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.text.DefaultStyledDocument;
import java.awt.geom.AffineTransform;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;


    @PostConstruct
    void intData() {
        Set<Role> rolseSet = new HashSet<>(roleRepository.findAll());
        Set<Authority> authoritySet=new HashSet<>(authorityRepository.findAll());
        for (Role role : rolseSet) {
            try {
                if (role.getName().equalsIgnoreCase("user")) {
                    role.setAuthorities(filterAuth(authoritySet,"READ"));
                } else if (role.getName().equalsIgnoreCase("admin")) {
                    role.setAuthorities(filterAuth(authoritySet,"READ","WRITE","DELETE"));
                }
                roleRepository.save(role);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private Set<Authority> filterAuth(Set<Authority> authorities,String...names){
        Set<Authority> filters=new HashSet<>();
        for(Authority authority:authorities){
            for (String name:names){
                if(authority.getName().equalsIgnoreCase(name)){
                    filters.add(authority);
                }
            }
        }
        return filters;
    }
}
