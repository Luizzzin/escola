package com.barbosa.escola.Service;

import com.barbosa.escola.Interface.AlunoRepository;
import com.barbosa.escola.Model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {

        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> buscarAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno salvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public void excluirAluno(Long id){
        alunoRepository.deleteById(id);
    }

    public Aluno buscarAlunoId(Long id){
       return alunoRepository.findById(id).orElse(null);

    }


}


