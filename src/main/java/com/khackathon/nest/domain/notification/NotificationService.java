package com.khackathon.nest.domain.notification;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.khackathon.nest.domain.admin.entity.Admin;
import com.khackathon.nest.domain.admin.repository.AdminRepository;
import com.khackathon.nest.domain.inquiry.entity.Inquiry;
import com.khackathon.nest.domain.shelter.entity.Shelter;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final AdminRepository adminRepository;

    @Async
    public void sendToAdmins(Shelter shelter, Inquiry inquiry) {
        adminRepository.findByShelterId(shelter.getId()).stream()
                .map(Admin::getFcmToken)
                .forEach(fcmToken -> sendPushNotification(fcmToken, shelter.getName(), inquiry.getTitle()));
    }

    private void sendPushNotification(String token, String title, String body) {
        Notification notification = Notification.builder()
                .setTitle(title)
                .setBody(body)
                .build();

        Message message = Message.builder()
                .setToken(token)
                .setNotification(notification)
                .build();
        try {
            FirebaseMessaging.getInstance().send(message);
            System.out.println("Successfully sent message");
        }
        catch (Exception e) {
            System.out.println("Failed to send message");
        }
    }
}
