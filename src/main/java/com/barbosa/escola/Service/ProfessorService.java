package com.barbosa.escola.Service;

import com.barbosa.escola.Interface.ProfessorRepository;
import com.barbosa.escola.Model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfessorService {
        private final ProfessorRepository professorRepository;

        public ProfessorService(ProfessorRepository professorRepository) {

            this.professorRepository = professorRepository;
        }

        public List<Professor> buscarProfessores(){
            return professorRepository.findAll();
        }

        public static Professor salvarProfessor(Professor professor){
            return ProfessorService.salvarProfessor(professor);
        }

        public void excluirProfessor(Long id){
            professorRepository.deleteById(id);
        }

        public Professor buscarProfessorId(Long id){
            return professorRepository.findById(id).orElse(null);

        }

}
