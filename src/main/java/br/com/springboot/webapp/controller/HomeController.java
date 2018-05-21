package br.com.springboot.webapp.controller;

import br.com.springboot.webapp.model.Employee;
import br.com.springboot.webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("emp", employeeService.employees());
        return "index";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String cadastro(Model model){
        Employee employee = new Employee();
        model.addAttribute("formModel", employee);
        return "cadastro";
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar(@ModelAttribute("formModel") Employee employee, Model model) {
        if (employee.getNome().isEmpty() || employee.getRegistro().isEmpty() ||
                                            employee.getTipoSanguineo().isEmpty()){
            model.addAttribute("msg","Preencha todos os campos.");
            return "cadastro";
        }
        if (employee.getId().isEmpty()) employee.setId(null);
        if (employeeService.save(employee)) {
            return "redirect:/";
        } else {
            model.addAttribute("msg","Erro. Não foi possível persistir os dados.");
            return "cadastro";
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable("id") String id, Model model){
        Optional<Employee> e = getEmployee(id);
        model.addAttribute("emp", e);
        return "cadastro";
    }

    private Optional<Employee> getEmployee(String id){
        Optional<Employee> emp = employeeService.employee(id);
        if (emp.isPresent()){
            return emp;
        } else {
            return emp.empty();
        }
    }
}
