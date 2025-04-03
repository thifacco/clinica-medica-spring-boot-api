package med.voll.clinica_medica_spring_boot_api.controller;

import jakarta.validation.Valid;
import med.voll.clinica_medica_spring_boot_api.medico.DadosCadastroMedico;
import med.voll.clinica_medica_spring_boot_api.medico.Medico;
import med.voll.clinica_medica_spring_boot_api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        this.repository.save(new Medico(dados));
    }
}
