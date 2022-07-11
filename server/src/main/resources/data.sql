-- Add Test student user
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10001, 'Test', 'Student 10001', 'teststudent1@gmail.com', 'teststudent1');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10002, 'Test', 'Student 10002', 'teststudent2@gmail.com', 'teststudent2');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10003, 'Test', 'Student 10003', 'teststudent3@gmail.com', 'teststudent3');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10004, 'Test', 'Student 10004', 'teststudent4@gmail.com', 'teststudent4');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10005, 'Test', 'Student 10005', 'teststudent5@gmail.com', 'teststudent5');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10006, 'Test', 'Student 10006', 'teststudent6@gmail.com', 'teststudent6');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10007, 'Test', 'Student 10007', 'teststudent7@gmail.com', 'teststudent7');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10008, 'Test', 'Student 10008', 'teststudent8@gmail.com', 'teststudent8');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10009, 'Test', 'Student 10009', 'teststudent9@gmail.com', 'teststudent9');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10010, 'Test', 'Student 10010', 'teststudent10@gmail.com', 'teststudent10');

INSERT INTO STUDENT(id)
VALUES (10001),
       (10002),
       (10003),
       (10004),
       (10005),
       (10006),
       (10007),
       (10008),
       (10009),
       (10010);

-- Add test faculty user

INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10011, 'Test', 'Faculty 10011', 'testfaculty11@gmail.com', 'testfaculty11');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10012, 'Test', 'Faculty 10012', 'testfaculty12@gmail.com', 'testfaculty12');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10013, 'Test', 'Faculty 10013', 'testfaculty13@gmail.com', 'testfaculty13');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10014, 'Test', 'Faculty 10014', 'testfaculty14@gmail.com', 'testfaculty14');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10015, 'Test', 'Faculty 10015', 'testfaculty15@gmail.com', 'testfaculty15');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10016, 'Test', 'Faculty 10016', 'testfaculty16@gmail.com', 'testfaculty16');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10017, 'Test', 'Faculty 10017', 'testfaculty17@gmail.com', 'testfaculty17');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10018, 'Test', 'Faculty 10018', 'testfaculty18@gmail.com', 'testfaculty18');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10019, 'Test', 'Faculty 10019', 'testfaculty19@gmail.com', 'testfaculty19');

INSERT INTO FACULTY(id)
VALUES (10011),
       (10012),
       (10013),
       (10014),
       (10015),
       (10016),
       (10017),
       (10018),
       (10019);

-- Add job tags
INSERT INTO tag(id, tag_name)
VALUES (10001, 'devops'),
       (10002, 'java developer'),
       (10003, 'senior engineer'),
       (10004, 'junior engineer'),
       (10005, 'software engineer'),
       (10006, 'android developer'),
       (10007, 'dot net developer'),
       (10008, 'lead engineer'),
       (10009, 'project manager'),
       (10010, 'frontend developer');

-- JOB advertisement data

--INSERT INTO tag_job_advertisement_list(job_advertisement_list_id, tag_id)
--VALUES (10001, 10001),
--       (10001, 10002),
--       (10001, 10004),
--       (10001, 10006);
--
--
--INSERT INTO tag_job_advertisement_list(job_advertisement_list_id, tag_id)
--VALUES (10002, 10001),
--       (10002, 10003),
--       (10002, 10008),
--       (10002, 10006);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10001, 'Fairfield', 'Iowa', '52557', 'Software Engineering II', 'Braintrust', 'N/A',
        'Braintrust is the only network that gives in-demand talent all the freedom of freelance with all the benefits, community and stability of a full-time role. As the first decentralized talent network, our revolutionary Web3 model ensures the community that relies on Braintrust to find work are the same people who own and build it through the blockchain token, BTRST. So unlike other marketplaces that take 10020% to 50% of talent earnings, Braintrust allows talent to keep 100% of earnings and to vote on key changes to improve the network. Braintrust is working to change the way freelance works – for good.',
        10001);

INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10002, 'Kurintar', 'Chitwan', '123456', 'DevOps Engineering', 'KForce', 'N/A',
        'Kforce has a client based out of Portland, OR that is seeking a Remote Full-Stack Cloud Engineering Manager. This position comes with many benefits including: a 401k with a 10006% match, immediate vesting, and allows you to live the dream of a flexible lifestyle with truly unlimited PTO. In this role, you will be accountable for the team''s output and growth. You will get the opportunity for hands on technical, and mentoring work, which will vary based on the team''s needs. We are looking ideally for someone who has technical skills, Cloud, and React experience.',
        10002);

INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10003, 'Boston', 'Massachussets', '543671', 'Software Engineering L3', 'Google', 'work from home',
        'At Google we work hard to earn our users’ trust every day. Trust & Safety is Google’s team of abuse fighting and user trust experts working daily to make the internet a safer place. We partner with teams across Google to deliver bold solutions in abuse areas such as malware, spam and account hijacking. A diverse team of Analysts, Policy Specialists, Engineers, and Program Managers, we work to reduce risk and fight abuse across all of Google’s products, protecting our users, advertisers, and publishers across the globe in over 40 languages.',
        10002);

INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10004, 'Seattle', 'California', '786567', 'Analyst - Software Engineering', 'Goldman Sachs',
        'Paternity and Maternity leave',
        'As a member of the RIA (Registered Investment Advisor) engineering team, you will be responsible for building out custody and trading systems that service institutional client needs at scale. As an engineer within RIA, you will be working in a close knit team at the forefront of shaping our clients experience by creating new technology driven businesses. This is an opportunity to work closely with experienced engineers, business developers, and a diverse client base to deliver APIs, services, and technology solutions that scale to meet a broad range of client needs. We are looking for engineers who thrive in a client-driven, agile environment.',
        10007);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10005, 'Palo Alto', 'California', '123456', 'Data Engineer', 'Apple', 'Work from Home',
        'This team designs, executes and builds tools for online experiments (A/B tests) and offline experiments (human relevance judgement) that help us improve and fine tune our data-driven features. Your primary focus will be to automate the delivery of various datasets by working with Data Scientists on the team to understand critical metrics/KPIs and how they are derived. You will write and maintain the code that ingests, computes and organizes various data sets.',
        10003);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10006, 'Chicago', 'Chicago', '786790', 'Cloud Software Engineer', 'American Express', 'N/A',
        'From building next-generation apps and microservices in Kotlin to using AI to help protect our customers from fraud, you could be doing transformational work that brings our iconic, global brand into the future. As a part of our tech team, we could work together to bring ground-breaking and diverse ideas to life that power the digital systems, services, products and platforms that millions of customers around the world depend on. If you love to work with APIs, contribute to open source, or use the latest technologies, we’ll support you with an open environment and learning culture to grow your career.',
        10003);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10007, 'Palo Alto', 'New Jersey', '567867', 'Machine Learning Engineer', 'Apple', 'Work from home',
        'You’ll join a fantastic team of world-class engineers and researchers with extensive experience and reputation in robotics and machine learning to work on very complex and exciting AI projects that could bring high impacts to society. We strive to develop innovative and industry-leading solutions for every challenging problem we work on.',
        10005);

INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10008, 'Nashvile', 'Tenesse', '454367', 'Software Engineer II', 'Medtronic', 'N/A',
        'The Research and Technology Advanced Development team is seeking a SW Engineer II to help develop the next generation of solutions for surgical navigation and robotics. The ideal candidate will be able to develop creative and state-of-the-art solutions using their software development skills for challenging and multifaceted problems. This role will interact with cross-functional teams and will support the identification of potential concepts, delivery of prototypes, and the ultimate transfer of these solutions to later stages of product development.',
        10003);

INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10009, 'Dallas', 'Texas', '989089', 'Python AWS Developer', 'Cognizant', 'N/A',
        'Digital technologies, including analytics and AI, give companies a once-in-a-generation opportunity to perform orders of magnitude better than ever before. But clients need new business models built from analyzing customers and business operations at every angle to really understand them. With the power to apply artificial intelligence and data science to business decisions via enterprise data management solutions, we help leading companies prototype, refine, validate and scale the most desirable products and delivery models to enterprise scale within weeks',
        10005);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10010, 'California', 'California', '23456', 'Machine Learning Engineer', 'JPMorgan Chase & Co.', 'Paid leaves',
        'Working for one of the largest banks, card issuers, and payments processors in the US, you will be fighting crime and protecting consumers and small businesses from financial fraud, including account takeovers and identity theft, with machine learning engineering solutions.In this role, you will be the working on implementing machine learning models and pipelines with opportunity to lead & own from project from start to end while partnering with various product & engineering teams. This includes understanding the business problem and requirements and converting them to technical stories, supporting data sourcing, feature engineering and productionizing pipelines and models.',
        10003);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10011, 'Georgia', 'Atlanta', '23452', 'Senior Software Engineer, Full Stack', 'KForce', 'Paternity leave',
        'Our client is the leading Web3 accelerator and founder community. Since early 2020, they have helped the top 1% of Web3 founders start and grow their companies. They do so through a 9-week program led by leading experts. The community includes fellow founders, lawyers, auditors, market makers and more. Together, they are estimated to grow Web3 to one billion users by 2025. They accelerated more than 90 startups with support from more than 200 entities in our support network.',
        10008);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10012, 'Seattle', 'California', '45678', 'Software Engineering', 'KForce', 'Paid leaves',
        'Kforce has a client in Los Angeles, CA that is seeking a remote DevOps Engineer I. Summary: The Information Security Operations Engineer will strategically improve cybersecurity compliance. The candidate will develop mitigation plans, configure tools, and action alerts to remediate cyber risk and complex threats in Amazon Web Services (AWS).',
        10007);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10013, 'New York', 'Washington', '345678', 'Senior Frontend Engineer', 'Twitter', 'N/A',
        'We are looking for individuals with vision, innovation, passion, technical excellence, drive to deliver, collaboration, and execution to help us disrupt the financial industry. Join a team of like-minded people who personify our mission of ownership, craftsmanship, and open communication.',
        10007);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10014, 'Kathmandu', 'Bagmati', '213568', 'Software Engineer II, Core', 'Google', 'Paid leaves',
        'The Core team builds the technical foundation behind Google’s flagship products. We are owners and advocates for the underlying design elements, developer platforms, product components, and infrastructure at Google. These are the essential building blocks for excellent, safe, and coherent experiences for our users and drive the pace of innovation for every developer. We look across Google’s products to build central solutions, break down technical barriers and strengthen existing systems. As the Core team, we have a mandate and a unique opportunity to impact important technical decisions across the company.',
        10001);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10015, 'Bharatpur', 'Chitwan', '123467', 'Cloud AI/ML Engineer, Public Sector, Professional Services', 'Google',
        'N/A',
        'The Core team builds the technical foundation behind Google’s flagship products. We are owners and advocates for the underlying design elements, developer platforms, product components, and infrastructure at Google. These are the essential building blocks for excellent, safe, and coherent experiences for our users and drive the pace of innovation for every developer. We look across Google’s products to build central solutions, break down technical barriers and strengthen existing systems. As the Core team, we have a mandate and a unique opportunity to impact important technical decisions across the company.',
        10001);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10016, 'Mountain View', 'California', '653578', 'Software Engineer III, Google Ads', 'Google', 'stock options',
        'At Google we work hard to earn our users’ trust every day. Trust & Safety is Google’s team of abuse fighting and user trust experts working daily to make the internet a safer place. We partner with teams across Google to deliver bold solutions in abuse areas such as malware, spam and account hijacking. A diverse team of Analysts, Policy Specialists, Engineers, and Program Managers, we work to reduce risk and fight abuse across all of Google’s products, protecting our users, advertisers, and publishers across the globe in over 40 languages.',
        10006);



INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10017, 'Redmond', 'Washington', '376854', 'Software Engineer', 'Microsoft', 'sign in bonus',
        'The focus of the Enterprise Support Specialist’s role is to drive and close Microsoft Enterprise Support opportunities to ensure customers are supported throughout all stages of the product lifecycle, improving their health and enabling customer outcomes and consumption. The Support Specialist leverages Microsoft’s unique expertise, including direct access to product teams, to help customers use their Microsoft investments as productively as possible.',
        10006);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10018, 'Redmond', 'Washington', '376854', 'Software Engineer II', 'Microsoft', 'Stock options',
        'Ability to meet Microsoft, customer and/or government security screening requirements are required for this role. Microsoft Cloud Background Check: This position will be required to pass the Microsoft Cloud Background Check upon hire/transfer and every two years thereafter.Microsoft is an equal opportunity employer. All qualified applicants will receive consideration for employment without regard to age, ancestry, color, family or medical care leave, gender identity or expression, genetic information, marital status, medical condition, national origin, physical or mental disability, political affiliation, protected veteran status, race, religion, sex (including pregnancy), sexual orientation, or any other characteristic protected by applicable laws, regulations and ordinances. We also consider qualified applicants regardless of criminal histories, consistent with legal requirements. If you need assistance and/or a reasonable accommodation due to a disability during the application or the recruiting process, please send a request via the Accommodation request form.',
        10005);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10019, 'Seattle', 'California', '236780', 'System Development Engineer', 'Amazon',
        'Huge stocks and yearly bonus',
        'We are looking for a Senior System Development Engineer to join our Network Automation Software team. Our team is responsible for software platforms that enable Amazon to safely operate and scale our network. An ideal candidate will have experience designing, building and maintaining mission critical software systems at scale, with a relentless focus on operational and engineering excellence.',
        10003);


INSERT INTO job_advertisement (id, city, state, zip, title, company_name, benefits, description, created_by)
VALUES (10020, 'Redmond', 'Washington', '376854', 'Devops Engineer', 'Amazon', 'N/A',
        'We are looking for passionate, hard-working, and talented DevOps Engineers who have experience supporting innovative, mission critical, high volume applications. You will have an enormous opportunity to work within multiple systems researching and identifying the common issues, and driving the teams towards resolution to have a positive impact on customer experience. This job requires you to hit the ground running and your ability to learn quickly and work on disparate and overlapping tasks will define your success. As a DevOps Engineer, you will be a part of 24X7 teams Oncall rotation.',
        10001);

--Adding job history dataset

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10001, 'Great company I have ever worked in my life.', 'Google', '2022-01-10', 'got the new job', '2022-02-10',10001);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10002, 'Decent work life balance.', 'Goldman Sachs', '2011-12-10',
        'Building my own startup for venture capatilists', '2012-05-15',10001);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10003, 'Met great work mates and great work life balance overall. Love the time on the company.', 'Microsoft',
        '2016-5-10', 'joining Google soon as Senior engineering lead manager', '2022-6-15',10001);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10004, 'Decent work experience and less growth of individual', 'Kforce', '2019-08-10',
        'joining Goldman sachs in devops teams', '2020-07-05',10001);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10005,
        'KFC, a subsidiary of Yum is a global chicken restaurant brand with a rich, decades-long history of success and innovation',
        'KFC', '2017-01-10', 'Opening my own food service', '2022-11-16',10001);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10006,
        'Amazon is guided by four principles: customer obsession rather than competitor focus, passion for invention, commitment to operational excellence, and long-term thinking. ',
        'Amazon', '2019-12-10', 'got the new job', '2022-07-01',10001);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10007, '"NASA is a great company to work for; where else can you put people in space as part of your job?"',
        'NASA', '2001-08-10', 'Retiring', '2022-06-30',10001);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10008,
        '"This was my first real world experience (internship), and I learnt a lot and was surrounded by like-minded and smart people."',
        'Motorola', '2011-12-10', 'not great work life balance', '2018-05-10',10002);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10009,
        'Cisco is a great company to work for and afforded me many opportunities to grow my career both internally and externally. "',
        'Cisco', '2019-09-15', 'got the new job', '2021-07-10',10002);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10010, '"Extremely demanding and rewarding, and worth the experience."', 'Pfizer', '2010-12-10',
        'got the new job', '2022-02-10',10002);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10011, 'Wellness packagae, internet reimbursement , and discounts and perks', 'Facebook', '2017-07-15',
        'Joining Google', '2022-06-30',10002);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10012, 'Great company I have ever worked in my life. Would recommend you to join the company.', 'Google',
        '2018-11-10', 'starting my own company', '2022-12-15',10002);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10013, 'Culture is about raising the bar. Expressive environment', 'Google', '2015-01-10',
        'on my next adventure', '2022-06-10',10002);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10014, 'Great company I have ever worked in my life.', 'Google', '2022-01-10', 'got the new job', '2022-02-10',10002);

INSERT INTO job_history (id, comments, company_name, end_date, reason_to_leave, start_date, student_id)
VALUES (10015, 'Feeling like I am valued and seen.', 'Microsoft', '2011-01-10', 'Retiring my career!', '2020-06-10',10002);


--Job Application data
--fields: id, deleted, job_advertisement_id

INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10001, TRUE, 10002);

INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10002, false, 10003);


INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10003, true, 10003);


INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10004, true, 10001);


INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10005, true, 10001);

INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10006, FALSE, 10002);

INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10007, true, 10001);


INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10008, true, 10001);


INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10009, FALSE, 10011);


INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10010, TRUE, 10011);

INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10011, FALSE, 10002);

INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10012, FALSE, 10011);


INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10013, true, 10010);


INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10014, FALSE, 10010);


INSERT INTO job_application (id, deleted, job_advertisement_id)
VALUES (10015, true, 10011);

--Add data in Department table
INSERT INTO department (id, delete, department_name)
VALUES (10001, TRUE, 'COMPRO');

INSERT INTO department (id, delete, department_name)
VALUES (10002, FALSE, 'MBA');

INSERT INTO department (id, delete, department_name)
VALUES (10003, TRUE, 'CSE');

INSERT INTO department (id, delete, department_name)
VALUES (10004, TRUE, 'ECE');

INSERT INTO department (id, delete, department_name)
VALUES (10005, FALSE, 'Arts');

--Add comment dataset

INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10001, 'great work, keep it up', TRUE, 10001, 10011);


INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10002, 'excellent work', FALSE, 10002, 10012);

INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10003, 'Impressive results.', TRUE, 10003, 10011);


INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10004, 'Keep up the great work.', FALSE, 10004, 10013);

INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10005, 'Bravo!', TRUE, 10005, 10014);

INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10006, 'You nailed it!', FALSE, 10006, 10015);

INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10007, 'You are genius.', TRUE, 10007, 10016);

INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10008, 'great work, keep it up', FALSE, 10008, 10017);

INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10009, 'Well done, you can do it better.', TRUE, 10009, 10018);

INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10010, 'Keep up the momentum.', FALSE, 10010, 10019);

INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10011, 'You will do great next time. Work hard.', TRUE, 10001, 10011);

INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10012, 'great work, keep it up', FALSE, 10001, 10011);

INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10013, 'Great job my dear student', TRUE, 10002, 10012);

INSERT INTO comment (id, comment, deleted, student_id, faculty_id)
VALUES (10014, 'You are genius.', FALSE, 10002, 10012);


-- Reset primary key sequence
select setval('job_advertisement_id_seq', max(id)) from job_advertisement;
select setval('comment_id_seq', max(id)) from comment;
select setval('job_application_id_seq', max(id)) from job_application;
select setval('job_history_id_seq', max(id)) from job_history;
select setval('tag_id_seq', max(id)) from tag;
select setval('users_id_seq', max(id)) from users;

