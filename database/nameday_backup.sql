--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3 (Debian 15.3-1.pgdg110+1)
-- Dumped by pg_dump version 15.3 (Debian 15.3-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: post
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO post;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: name; Type: TABLE; Schema: public; Owner: post
--

CREATE TABLE public.name (
    id bigint NOT NULL,
    count integer,
    date character varying(255),
    name character varying(255),
    nameday_id bigint
);


ALTER TABLE public.name OWNER TO post;

--
-- Name: nameday_id_seq; Type: SEQUENCE; Schema: public; Owner: post
--

CREATE SEQUENCE public.nameday_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nameday_id_seq OWNER TO post;

--
-- Name: nameday; Type: TABLE; Schema: public; Owner: post
--

CREATE TABLE public.nameday (
    id integer DEFAULT nextval('public.nameday_id_seq'::regclass) NOT NULL,
    date character varying(255),
    name character varying(255),
    count integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.nameday OWNER TO post;

--
-- Data for Name: name; Type: TABLE DATA; Schema: public; Owner: post
--

COPY public.name (id, count, date, name, nameday_id) FROM stdin;
\.


--
-- Data for Name: nameday; Type: TABLE DATA; Schema: public; Owner: post
--

COPY public.nameday (id, date, name, count) FROM stdin;
4	30-11	Ondra	1
8	07-03	Tomáš	0
9	18-10	Lukáš	0
7	24-06	Jan	4
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: post
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, true);


--
-- Name: nameday_id_seq; Type: SEQUENCE SET; Schema: public; Owner: post
--

SELECT pg_catalog.setval('public.nameday_id_seq', 9, true);


--
-- Name: name name_pkey; Type: CONSTRAINT; Schema: public; Owner: post
--

ALTER TABLE ONLY public.name
    ADD CONSTRAINT name_pkey PRIMARY KEY (id);


--
-- Name: nameday nameday_pkey; Type: CONSTRAINT; Schema: public; Owner: post
--

ALTER TABLE ONLY public.nameday
    ADD CONSTRAINT nameday_pkey PRIMARY KEY (id);


--
-- Name: name fkhjsbf192beche23d3akl7ceft; Type: FK CONSTRAINT; Schema: public; Owner: post
--

ALTER TABLE ONLY public.name
    ADD CONSTRAINT fkhjsbf192beche23d3akl7ceft FOREIGN KEY (nameday_id) REFERENCES public.nameday(id);


--
-- PostgreSQL database dump complete
--

