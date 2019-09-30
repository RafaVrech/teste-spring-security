package example.springdata.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
@RequestMapping("/empregado")
public class EmpregadoController {
    @Autowired
    EmployeeRepository employeeRepository;
    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Object> busca() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

}
