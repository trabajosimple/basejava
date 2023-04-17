package com.urise.webapp.storage;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;

import com.urise.webapp.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class ResumeTestData {
  protected static final Resume R1 = new Resume("uuid1", "Григорий Кислин");

  static {
    R1.setContact(PHONE, "+7(921) 855-0482");
    R1.setContact(SKYPE, "skype:grigory.kislin");
    R1.setContact(MAIL, "mailto:gkislin@yandex.ru");
    R1.setContact(LINKEDIN, "https://www.linkedin.com/in/gkislin");
    R1.setContact(GITHUB, "https://github.com/gkislin");
    R1.setContact(STATCKOVERFLOW, "https://stackoverflow.com/users/548473");
    R1.setContact(HOME_PAGE, "http://gkislin.ru/");

    R1.setSection(
        OBJECTIVE,
        new TextSection(
            "Ведущий стажировок и корпоративного обучения по "
                + "Java Web и Enterprise технологиям"));
    R1.setSection(
        PERSONAL,
        new TextSection(
            "Аналитический склад ума, сильная логика, креативность, "
                + "инициативность. Пурист кода и архитектуры."));

    R1.setSection(
        ACHIEVEMENT,
        new ListSection(
            new ArrayList(
                Arrays.asList(
                    "Организация команды и успешная реализация Java проектов "
                        + "для сторонних заказчиков: приложения автопарк на стеке Spring "
                        + "Cloud/микросервисы, система мониторинга показателей спортсменов на "
                        + "Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot "
                        + "+ Vaadin проект для комплексных DIY смет.",
                    "С 2013 года: разработка проектов \"Разработка Web приложения\","
                        + "\"Java Enterprise\", \"Многомодульный maven. Многопоточность. "
                        + "XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие "
                        + "(JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. "
                        + "Более 3500 выпускников.",
                    "Реализация двухфакторной аутентификации для онлайн платформы управления "
                        + "проектами Wrike. Интеграция с Twilio, DuoSecurity, Google "
                        + "Authenticator, Jira, Zendesk.",
                    "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM."
                        + " Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения"
                        + " управления окружением на стеке: Scala/Play/Anorm/JQuery. "
                        + "Разработка SSO аутентификации и авторизации различных ERP модулей, "
                        + "интеграция CIFS/SMB java сервера.",
                    "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, "
                        + "Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock "
                        + "для алгоритмического трейдинга.",
                    "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных"
                        + " сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор "
                        + "статистики сервисов и информации о состоянии через систему мониторинга "
                        + "Nagios. Реализация онлайн клиента для администрирования и мониторинга "
                        + "системы по JMX (Jython/ Django).",
                    "Реализация протоколов по приему платежей всех основных платежных системы России"
                        + " (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) "
                        + "и Никарагуа."))));
    R1.setSection(
        QUALIFICATIONS,
        new ListSection(
            new ArrayList(
                Arrays.asList(
                    "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty,WebLogic, WSO2",
                    "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                    "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, "
                        + "MySQL, SQLite, MS SQL, HSQLDB",
                    "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                    "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, "
                        + "Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink),"
                        + " Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons,"
                        + " Eclipse SWT, JUnit, Selenium (htmlelements).",
                    "Python: Django.",
                    "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                    "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                    "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, "
                        + "StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet,"
                        + " HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                    "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
                    "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher,"
                        + " Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer",
                    "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования,"
                        + " архитектурных шаблонов, UML, функционального программирования",
                    "Родной русский, английский \"upper intermediate\""))));

    R1.setSection(
        EXPERIENCE,
        new OrganizationSection(
            new ArrayList(
                Arrays.asList(
                    new Organization(
                        "Java Online Projects",
                        "https://javaops.ru/",
                        LocalDate.of(2013, 10, 1),
                        LocalDate.now(),
                        "Автор проекта",
                        "Создание, организация и проведение Java онлайн проектов и стажировок."),
                    new Organization(
                        "Wrike",
                        "https://www.wrike.com/vw/",
                        LocalDate.of(2014, 10, 1),
                        LocalDate.of(2016, 1, 1),
                        "Старший разработчик (backend)",
                        "Проектирование и разработка онлайн платформы управления проектами Wrike "
                            + "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). "
                            + "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."),
                    new Organization(
                        "RIT Center",
                        "",
                        LocalDate.of(2012, 4, 1),
                        LocalDate.of(2014, 10, 1),
                        "Java архитектор",
                        "Организация процесса разработки системы ERP для разных окружений: "
                            + "релизная политика, версионирование, ведение CI (Jenkins), миграция "
                            + "базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), "
                            + "AAA via SSO. Архитектура БД и серверной части системы. Разработка "
                            + "интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего"
                            + " назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN "
                            + "для online редактирование из браузера документов MS Office. Maven + "
                            + "plugin development, Ant, Apache Commons, Spring security, Spring MVC, "
                            + "Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell "
                            + "remote scripting via ssh tunnels, PL/Python"),
                    new Organization(
                        "Luxoft (Deutsche Bank)",
                        "http://www.luxoft.ru/",
                        LocalDate.of(2010, 12, 1),
                        LocalDate.of(2012, 4, 1),
                        "Ведущий программист",
                        "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring,"
                            + " Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и "
                            + "серверной части CRM. Реализация RIA-приложения для администрирования, "
                            + "мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, "
                            + "Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."),
                    new Organization(
                        "Yota",
                        "https://www.yota.ru/",
                        LocalDate.of(2008, 6, 1),
                        LocalDate.of(2010, 12, 1),
                        "Ведущий специалист",
                        "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные "
                            + "Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, "
                            + "JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и "
                            + "мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, "
                            + "Django, ExtJS)"),
                    new Organization(
                        "Enkata",
                        "http://enkata.com/",
                        LocalDate.of(2007, 3, 1),
                        LocalDate.of(2008, 6, 1),
                        "Разработчик ПО",
                        "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, "
                            + "Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP,"
                            + " Data mining)."),
                    new Organization(
                        "Siemens AG",
                        "https://www.siemens.com/ru/ru/home.html",
                        LocalDate.of(2005, 1, 1),
                        LocalDate.of(2007, 2, 1),
                        "Разработчик ПО",
                        "Разработка информационной модели, проектирование интерфейсов, "
                            + "реализация и отладка ПО на мобильной IN платформе Siemens @vantage "
                            + "(Java, Unix)"),
                    new Organization(
                        "Alcatel",
                        "http://www.alcatel.ru/",
                        LocalDate.of(1997, 9, 1),
                        LocalDate.of(2005, 1, 1),
                        "Инженер по аппаратному и программному тестированию",
                        "Тестирование, отладка, внедрение ПО цифровой телефонной станции "
                            + "Alcatel 1000 S12 (CHILL, ASM).")))));

    R1.setSection(
        EDUCATION,
        new OrganizationSection(
            new ArrayList(
                Arrays.asList(
                    new Organization(
                        "Siemens AG",
                        "http://www.siemens.ru/",
                        LocalDate.of(2005, 1, 1),
                        LocalDate.of(2005, 4, 1),
                        "3 месяца обучения мобильным IN сетям (Берлин)",
                        ""),
                    new Organization(
                        "Alcatel",
                        "http://www.alcatel.ru/",
                        LocalDate.of(1997, 9, 1),
                        LocalDate.of(1998, 8, 1),
                        "6 месяцев обучения цифровым телефонным сетям (Москва)",
                        ""),
                    new Organization(
                        "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                        "http://www.ifmo.ru/",
                        LocalDate.of(1993, 9, 1),
                        LocalDate.of(1996, 7, 1),
                        "Аспирантура (программист С, С++)",
                        ""),
                    new Organization(
                        "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                        "http://www.ifmo.ru/",
                        LocalDate.of(1987, 7, 1),
                        LocalDate.of(1993, 9, 1),
                        "Инженер (программист Fortran, C)",
                        ""),
                    new Organization(
                        "Заочная физико-техническая школа при МФТИ",
                        "https://mipt.ru/",
                        LocalDate.of(1984, 9, 1),
                        LocalDate.of(1987, 6, 1),
                        "Закончил с отличием\n",
                        "")))));
  }
  
  public static void main(String[] args){
    System.out.println(R1);
  }
}
