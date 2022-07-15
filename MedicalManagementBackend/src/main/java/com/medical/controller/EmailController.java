package com.medical.controller;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.medical.model.User;

@RestController
@CrossOrigin("*")
public class EmailController {
	@Autowired
    SpringTemplateEngine templateEngine;

    @Autowired
    private JavaMailSender sender;
    
    @RequestMapping("/getdetails")
    public @ResponseBody User sendMail(@RequestBody User user) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("Username",user.getUsername());
        model.put("Password",user.getPasssword());
        model.put("FirstName",user.getFirstName());
        model.put("LastName",user.getLastName());
        model.put("Email", user.getEmail());
        model.put("Phone Number", user.getPhone());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("email-template", context);
      
//      System.out.println(html);
        try {
            helper.setTo(user.getEmail());
          helper.setText("Username:"+user.getUsername()+"  FirstName:"+user.getFirstName()+"  LastName:"+user.getLastName()+"  Email:"+user.getEmail()+"  Phone:"+user.getPhone(), false);
            //helper.setText(html,true);
            helper.setSubject("Registration Confirmation From Gupta Healthcare.");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return user;
}
}