package br.edu.ifrs.osorio.tads.web;

import br.edu.ifrs.osorio.tads.web.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();

    public ClienteController() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNome("João");
        cliente1.setEmail("joao@gmail.com");
        cliente1.setTelefone("9999-9999");
        clientes.add(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNome("Maria");
        cliente2.setEmail("maria@gmail.com");
        cliente2.setTelefone("8888-8888");
        clientes.add(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setId(3);
        cliente3.setNome("José");
        cliente3.setEmail("jose@hotmail.com");
        cliente3.setTelefone("7777-7777");
        clientes.add(cliente3);

        Cliente cliente4 = new Cliente();
        cliente4.setId(4);
        cliente4.setNome("Ana");
        cliente4.setEmail("ana@gmail.com");
        cliente4.setTelefone("6666-6666");
        clientes.add(cliente4);

    }
    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }

    @GetMapping("/preparaInsere")
    public String preparaInsere(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "insere";
    }

    @PostMapping("/inclui")
    public String insere(@ModelAttribute Cliente cliente) {
        clientes.add(cliente);
        return "redirect:/cliente/lista";
    }

    @GetMapping("/preparaEdita/{id}")
    public String preparaEdita(@PathVariable("id") int id, Model model) {
        System.out.println("entrou no prepara edita");
        Cliente cliente = listaPorId(id);
        model.addAttribute("cliente", cliente);
        return "altera";
    }

    @PostMapping("/edita")
    public String edita(@ModelAttribute Cliente cliente) {
        System.out.println("entrou no edita");
        System.out.println("Id do cliente: " + cliente.getId());

        Cliente cli = listaPorId(cliente.getId());
        if (cli != null) {
            clientes.remove(cli);
        }
        clientes.add(cliente);

        return "redirect:/cliente/lista";
    }

    @GetMapping("/exclui/{id}")
    public String exclui(@PathVariable("id") int id) {
        Cliente cli = listaPorId(id);
        if (cli != null) {
            clientes.remove(cli);
        }

        return "redirect:/cliente/lista";
    }

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("clientes", clientes);
        return "listagem";
    }

    private Cliente listaPorId(int id) {
        Cliente cli = null;

        for (Cliente c : clientes) {
            if (c.getId() == id) {
                cli = c;
            }
        }
        return cli;
    }
}
