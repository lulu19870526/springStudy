package com.applicationListener.selfDefine;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 可以自定义事件，然后做完业务处理后手动发出。同上集成某个监听接口，接收到事件后进行业务处理
 */
@Component
public class EmailNotifier implements ApplicationListener {
   public void onApplicationEvent(ApplicationEvent event) {
      if (event instanceof EmailEvent) {
         EmailEvent emailEvent = (EmailEvent)event;
         System.out.println("邮件地址：" + emailEvent.getAddress());
         System.out.println("邮件内容：" + emailEvent.getText());
         } else {
            System.out.println("容器本身事件：" + event);
    }
}

}
