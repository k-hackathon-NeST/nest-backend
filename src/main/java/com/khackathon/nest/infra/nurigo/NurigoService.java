package com.khackathon.nest.infra.nurigo;

import com.khackathon.nest.domain.inquiry.entity.Inquiry;
import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NurigoService {

    private final DefaultMessageService messageService;

    @Async
    public void sendMessage(Inquiry inquiry) {
        Message message = new Message();
        message.setFrom("01023679323");
        message.setTo(inquiry.getPhoneNumber());
        message.setText("[NeST] 작성하신 글 \"" + inquiry.getTitle() + "\" 의 답변이 추가되었습니다."
                + "\n" + "<답변 내용>" + "\n" +
                inquiry.getAnswer());
        messageService.sendOne(new SingleMessageSendingRequest(message));
    }
}
