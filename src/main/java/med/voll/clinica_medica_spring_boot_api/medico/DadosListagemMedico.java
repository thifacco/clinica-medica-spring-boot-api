package med.voll.clinica_medica_spring_boot_api.medico;

public record DadosListagemMedico(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
