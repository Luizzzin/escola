package com.barbosa.escola.Controller;

import com.barbosa.escola.Model.Professor;
import com.barbosa.escola.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> listaDeProfessores(){
        return professorService.buscarProfessores();
    }

    @PostMapping
    public Professor criarProfessor(@RequestBody Professor professor){
        return ProfessorService.salvarProfessor(professor);
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id){
        professorService.excluirProfessor(id);
    }

    @PutMapping("/{id}")
    public Professor atualizar(@PathVariable Long id, @RequestBody Professor professor){
        Professor verificaProfessor = professorService.buscarProfessorId(id);
        if(verificaProfessor == null) return null;

        verificaProfessor.setNomeProfessor(professor.getNomeProfessor());
        verificaProfessor.setEmailProfessor(professor.getEmailProfessor());
        verificaProfessor.setTelefoneProfessor(professor.getTelefoneProfessor());
        verificaProfessor.setId(professor.getId());

        return professorService.salvarProfessor(verificaProfessor);
    }

}

