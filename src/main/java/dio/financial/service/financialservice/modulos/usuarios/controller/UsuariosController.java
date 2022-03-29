package dio.financial.service.financialservice.modulos.usuarios.controller;

import dio.financial.service.financialservice.modulos.usuarios.Entities.Usuarios;
import dio.financial.service.financialservice.modulos.usuarios.dtos.DisplayUsuarioDto;
import dio.financial.service.financialservice.modulos.usuarios.service.UsuariosLoginService;
import dio.financial.service.financialservice.modulos.usuarios.service.UsuariosService;
import dio.financial.service.financialservice.modulos.usuarios.util.EncriptarSenhaUsuarios;
import dio.financial.service.financialservice.modulos.usuarios.util.UsuariosUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private UsuariosUtil usuariosUtil;

    @Autowired
    private UsuariosLoginService loginService;

    @PostMapping
    public @ResponseBody
    Usuarios novoUsuario(Usuarios u) {

        try {
            if(usuariosUtil.validateUsuario(u) == false) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            return usuariosService.novoUsuario(u);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<Usuarios> ProcurarPorId(@PathVariable int id) {

        return usuariosService.procurarPorId(id);

    }

    @PutMapping(path = "/modificarusuario/{id}")
    public @ResponseBody
    Usuarios modificarUsuario(@PathVariable int id, Usuarios usuario) {
        try {
            if(usuariosUtil.validateUsuario(usuario) == false) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            int i = usuariosService.modificarUsuario(id, usuario);
            if(i == 1) {
                return usuario;
            }
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public void deletarUsuario(@PathVariable int id) {
        try {
            usuariosService.deletarUsuario(id);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/listarporfiltros")
    public @ResponseBody
    List<Usuarios> listar(@RequestParam(value = "nome") String nome,
                          @RequestParam(value = "email") String email) {

        if((nome == null || nome == "") && (email == null || email == "")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        try{
            return usuariosService.listarPorFiltros(nome, email);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /*
    @GetMapping(path = "/listarfiltros/{nome}&{email}")
    public List<Usuarios> listarPorFiltros(@PathVariable String nome,@PathVariable String email) {
        System.out.println("chegou " + nome + email);
        if((nome == null || nome == "") || (email == null || email == "")) {
            System.out.println("chegou " + nome + email);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        try{
            return usuariosService.listarPorFiltros(nome, email);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }*/

    @GetMapping(path = "/login")
    public String checarLogin(@RequestParam(value = "login") String login,
                              @RequestParam(value = "senha") String senha) {

        try {
            Usuarios usuario = loginService.checarLogin(login, senha);
            if(usuario != null) {
                System.out.println("ok3");
                return "Usuario conectado";
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
