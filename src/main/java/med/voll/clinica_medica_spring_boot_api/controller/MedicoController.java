package med.voll.clinica_medica_spring_boot_api.controller;

import jakarta.validation.Valid;
import med.voll.clinica_medica_spring_boot_api.medico.DadosCadastroMedico;
import med.voll.clinica_medica_spring_boot_api.medico.DadosListagemMedico;
import med.voll.clinica_medica_spring_boot_api.medico.Medico;
import med.voll.clinica_medica_spring_boot_api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        this.repository.save(new Medico(dados));
    }

    @GetMapping
    public List<DadosListagemMedico> listar() {
        return this.repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }
}
