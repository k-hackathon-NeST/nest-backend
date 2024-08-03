package com.khackathon.nest.domain.inquiry.entity;

import com.khackathon.nest.domain.inquiry.dto.request.InquiryCreateRequest;
import com.khackathon.nest.domain.inquiry.dto.request.InquiryReplyRequest;
import com.khackathon.nest.domain.shelter.domain.Shelter;
import com.khackathon.nest.domain.staff.domain.Admin;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;

@Entity(name = "inquiry")
@Getter
public class Inquiry {
    @Id @GeneratedValue
    @Column(name = "inquiry_id")
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotBlank
    private String grade;

    @NotNull
    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @NotNull
    @Column(name = "discharge_date")
    private LocalDate dischargeDate;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String password;

    @NotNull
    @Column(name = "ask_at")
    private LocalDateTime askAt;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    @NotNull
    private Boolean isAnswer;

    private String answer;

    @Column(name = "answer_date")
    private LocalDateTime answerDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public static Inquiry toEntity(InquiryCreateRequest request, Shelter shelter) {
        Inquiry inquiry = new Inquiry();
        inquiry.name = request.getName();
        inquiry.phoneNumber = request.getPhoneNumber();
        inquiry.birthDate = request.getBirthDate();
        inquiry.grade = request.getGrade();
        inquiry.admissionDate = request.getAdmissionDate();
        inquiry.dischargeDate = request.getDischargeDate();
        inquiry.title = request.getTitle();
        inquiry.content = request.getContent();
        inquiry.password = request.getPassword();
        inquiry.askAt = LocalDateTime.now();
        inquiry.isAnswer = false;
        inquiry.shelter = shelter;
        return inquiry;
    }

    public void updateReply(InquiryReplyRequest request, Admin admin) {
        this.isAnswer = true;
        this.answerDate = LocalDateTime.now();
        this.answer = request.getAnswer();
        this.admin = admin;
    }
}
