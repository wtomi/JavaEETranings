/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.NewsItem;
import ejb.NewsItemFacadeLocal;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.*;

/**
 *
 * @author Tomi
 */
@Named
@RequestScoped
public class News {

    private String headingText;

    private String bodyText;

    @EJB
    private NewsItemFacadeLocal newsItemFacade;

    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:app/jms/NewsQueue")
    private javax.jms.Queue queue;

    public void submitNews() {
        sendNewsItem(headingText, bodyText);
    }

    public List<NewsItem> getNewsItems() {
        return newsItemFacade.findAll();
    }

    void sendNewsItem(String heading, String body) {
        try (Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession();
                MessageProducer messageProducer = session.createProducer(queue);) {
            ObjectMessage message = session.createObjectMessage();
            NewsItem e = new NewsItem();
            e.setHeading(heading);
            e.setBody(body);
            message.setObject(e);
            messageProducer.send(message);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return the headingText
     */
    public String getHeadingText() {
        return headingText;
    }

    /**
     * @param headingText the headingText to set
     */
    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    /**
     * @return the bodyText
     */
    public String getBodyText() {
        return bodyText;
    }

    /**
     * @param bodyText the bodyText to set
     */
    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

}
