package com.korea.basic1.question;

import java.util.List;

import com.korea.basic1.DataNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.Optional;
import com.korea.basic1.DataNotFoundException;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }
    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
}