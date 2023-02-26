DROP TABLE IF EXISTS public.student_lesson;
DROP TABLE IF EXISTS public.student;
DROP TABLE IF EXISTS public.lesson;

CREATE TABLE public.lesson (
                               id int8 NOT NULL,
                               courselength int4 NULL,
                               courselevel int4 NULL,
                               "name" varchar(255) NULL,
                               CONSTRAINT lesson_pkey PRIMARY KEY (id)
);

CREATE TABLE public.student (
                                id int8 NOT NULL,
                                "name" varchar(255) NOT NULL,
                                surname varchar(255) NOT NULL,
                                CONSTRAINT student_pkey PRIMARY KEY (id)
);

CREATE TABLE public.student_lesson (
                                       student_id int8 NOT NULL,
                                       lesson_id int8 NOT NULL,
                                       CONSTRAINT student_lesson_pkey PRIMARY KEY (student_id, lesson_id),
                                       CONSTRAINT fkn7jtimd1dtcijcc4eplcdgj9c FOREIGN KEY (lesson_id) REFERENCES public.lesson(id),
                                       CONSTRAINT fkr97jfr2vxnfydtu0p96wn8qpj FOREIGN KEY (student_id) REFERENCES public.student(id)
);