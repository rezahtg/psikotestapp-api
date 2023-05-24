package com.reza.psikotestapp.Config;

import com.reza.psikotestapp.models.Exam;
import com.reza.psikotestapp.repositories.ExamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final ExamRepository examRepository;

    public BootstrapData(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Exam exam1 = new Exam();
        exam1.setCategory("PERSONALITY");
        exam1.setQuestion("Jawablah pertanyaan Berikut");
        exam1.setQuestionContent("img-exam-1.jpg");
        exam1.setOption1("A. Lari");
        exam1.setOption2("B. Jalan");
        exam1.setOption3("C. Renang");
        exam1.setOption4("D. Membaca");
        exam1.setAnswer("A");

        Exam exam2 = new Exam();
        exam2.setCategory("PERSONALITY");
        exam2.setQuestion("Jawablah pertanyaan Berikut");
        exam2.setQuestionContent("img-exam-1.jpg");
        exam2.setOption1("A. Pemberani");
        exam2.setOption2("B. Pelari");
        exam2.setOption3("C. Pendaki");
        exam2.setOption4("D. Pemarah");
        exam2.setAnswer("C");

        System.out.println(exam2);
        examRepository.save(exam1);
        examRepository.save(exam2);
        System.out.println("Bootstrap Data Created");
        System.out.println(examRepository.count());
    }
}
