package com.WebAutomation

import com.RestAutomation.helper.ConfigurationHelper
import com.googlecode.totallylazy.regex.Regex

import javax.mail.Flags
import javax.mail.Folder
import javax.mail.Message
import javax.mail.Session
import javax.mail.Store
import java.util.regex.Pattern

/**
 * Created by yusoof on 9/9/16.
 */
public class MailVerifier {
    String emailServer
    String email
    String password
    String messageText

    Folder folder
    Session session
    Store store

    Message[] messages = null

    boolean mailFound = false

    public MailVerifier(String emailServer, String email, String password){
        this.email = email
        this.emailServer = emailServer
        this.password = password
        emailPropertiesSetup()
    }

    public emailPropertiesSetup(){
        Properties props = System.getProperties()
        props.setProperty("mail.store.protocol", "imaps")

        session = Session.getDefaultInstance(props, null)
        store = session.getStore("imaps")
        store.connect(emailServer, email, password)
        folder = store.getFolder("INBOX")

        folder.open(Folder.READ_WRITE)
    }

    public boolean isMailFound(String message){
        messages = folder.getMessages()
        for(Message mail : messages){
            println mail.getFrom()
            if(mail.getSubject().equals(message)){
                messageText = mail.getContent().toString()
                mailFound = true
                mail.setFlag(Flags.Flag.DELETED, true)
            }
        }
        return mailFound
    }


    public String getRetrievalLink(){
        def pattern1 = /(?ms)A forgot password retrieval was initiated from (.*) to ${ConfigurationHelper.emailAddress}/
        def matcher = messageText =~ pattern1
        if (matcher.find()) {
            return matcher.group(1)
        }
            return null
    }

    String getEmailServer() {
        return emailServer
    }

    String getEmail() {
        return email
    }

    String getPassword() {
        return password
    }
}
