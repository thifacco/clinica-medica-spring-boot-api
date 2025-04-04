package med.voll.clinica_medica_spring_boot_api.controller;

import jakarta.validation.Valid;
import med.voll.clinica_medica_spring_boot_api.medico.DadosCadastroMedico;
import med.voll.clinica_medica_spring_boot_api.medico.DadosListagemMedico;
import med.voll.clinica_medica_spring_boot_api.medico.Medico;
import med.voll.clinica_medica_spring_boot_api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 2, sort = {"nome"}) Pageable paginacao) {
        return this.repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
