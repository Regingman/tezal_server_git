-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3302
-- Время создания: Июл 13 2020 г., 13:18
-- Версия сервера: 10.3.13-MariaDB-log
-- Версия PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `tezal`
--

-- --------------------------------------------------------

--
-- Структура таблицы `budget`
--

CREATE TABLE `budget` (
  `id` bigint(20) NOT NULL,
  `amount` float NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `budget`
--

INSERT INTO `budget` (`id`, `amount`, `create_date`, `update_date`) VALUES
(1, 100, '2020-02-06 00:00:00', '2020-02-06 00:00:00'),
(2, 100, '2020-02-06 00:00:00', '2020-02-06 00:00:00');

-- --------------------------------------------------------

--
-- Структура таблицы `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `category`
--

INSERT INTO `category` (`id`, `create_date`, `name`, `update_date`) VALUES
(1, '2020-02-05 00:00:00', 'Соки', '2020-02-05 00:00:00');

-- --------------------------------------------------------

--
-- Структура таблицы `client`
--

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `patronymic` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telephon_number` int(11) NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `client`
--

INSERT INTO `client` (`id`, `create_date`, `email`, `first_name`, `last_name`, `password`, `patronymic`, `telephon_number`, `update_date`) VALUES
(1, '2020-02-06 00:00:00', 'тест', 'тест', 'тест', 'тест', 'тест', 123, '2020-02-06 00:00:00');

-- --------------------------------------------------------

--
-- Структура таблицы `container`
--

CREATE TABLE `container` (
  `id` bigint(20) NOT NULL,
  `budget_id` bigint(20) NOT NULL,
  `container_category_id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `number` int(11) NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `container`
--

INSERT INTO `container` (`id`, `budget_id`, `container_category_id`, `create_date`, `name`, `number`, `update_date`) VALUES
(1, 1, 1, '2020-02-06 00:00:00', 'A', 1, '2020-02-14 10:23:14'),
(2, 1, 1, '2020-02-11 00:00:00', 'B', 2, '2020-02-11 00:00:00'),
(3, 1, 1, '2020-02-11 00:00:00', 'C', 3, '2020-02-11 00:00:00'),
(4, 1, 1, '2020-02-14 10:16:50', 'A', 4, '2020-02-14 10:16:50'),
(5, 1, 1, '2020-02-14 10:18:45', 'A', 5, '2020-02-14 10:18:45'),
(6, 1, 2, '2020-02-15 15:45:45', 'B', 6, '2020-02-15 15:45:45'),
(7, 1, 2, '2020-02-15 15:45:45', 'B', 7, '2020-02-15 15:45:45'),
(8, 1, 2, '2020-02-15 15:45:45', 'B', 8, '2020-02-15 15:45:45'),
(9, 1, 2, '2020-02-15 15:45:45', 'B', 9, '2020-02-15 15:45:45'),
(10, 1, 2, '2020-02-15 15:45:45', 'B', 10, '2020-02-15 15:45:45'),
(11, 1, 2, '2020-02-15 15:45:45', 'B', 11, '2020-02-15 15:45:45'),
(12, 1, 3, '2020-02-15 15:45:45', 'B', 12, '2020-02-15 15:45:45'),
(13, 1, 3, '2020-02-15 15:45:45', 'B', 13, '2020-02-15 15:45:45'),
(14, 1, 3, '2020-02-15 15:45:45', 'B', 14, '2020-02-15 15:45:45'),
(15, 1, 1, '2020-02-15 15:45:45', 'B', 15, '2020-02-15 15:45:45'),
(16, 1, 1, '2020-02-15 15:45:45', 'B', 16, '2020-02-15 15:45:45'),
(17, 1, 1, '2020-02-15 15:45:45', 'B', 17, '2020-02-15 15:45:45'),
(18, 1, 1, '2020-02-15 15:45:45', 'B', 18, '2020-02-15 15:45:45'),
(19, 1, 1, '2020-02-15 15:45:45', 'B', 19, '2020-02-15 15:45:45'),
(20, 1, 1, '2020-02-15 15:45:45', 'B', 20, '2020-02-15 15:45:45');

-- --------------------------------------------------------

--
-- Структура таблицы `container_category`
--

CREATE TABLE `container_category` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `container_category`
--

INSERT INTO `container_category` (`id`, `create_date`, `name`, `update_date`) VALUES
(1, '2020-02-06 00:00:00', 'Мыломоющие', '2020-02-06 00:00:00'),
(2, '2020-02-06 00:00:00', 'Пряности', '2020-02-06 00:00:00'),
(3, '2020-02-06 00:00:00', 'Мясные', '2020-02-06 00:00:00');

-- --------------------------------------------------------

--
-- Структура таблицы `customer_discount`
--

CREATE TABLE `customer_discount` (
  `id` bigint(20) NOT NULL,
  `client_id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `discount_id` bigint(20) NOT NULL,
  `percent` float NOT NULL,
  `summ` float NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `discount`
--

CREATE TABLE `discount` (
  `id` bigint(20) NOT NULL,
  `container_id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `percent` float NOT NULL,
  `summ` float NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `container_id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `client_id` bigint(20) NOT NULL,
  `container_id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `deadline_date` datetime NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `orders_status_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `orders`
--

INSERT INTO `orders` (`id`, `client_id`, `container_id`, `create_date`, `deadline_date`, `update_date`, `orders_status_id`) VALUES
(8, 1, 1, '2020-02-15 12:48:25', '2020-02-15 12:48:25', '2020-02-15 12:48:25', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `order_status`
--

CREATE TABLE `order_status` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `order_status`
--

INSERT INTO `order_status` (`id`, `create_date`, `name`, `update_date`) VALUES
(1, '2020-02-06 00:00:00', 'корзина', '2020-02-06 00:00:00');

-- --------------------------------------------------------

--
-- Структура таблицы `purchase`
--

CREATE TABLE `purchase` (
  `id` bigint(20) NOT NULL,
  `bar_code` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `container_id` bigint(20) NOT NULL,
  `count` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `price_for_one` float NOT NULL,
  `publisher` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `rate_id` bigint(20) NOT NULL,
  `summ` float NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `raw_material_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `rate`
--

CREATE TABLE `rate` (
  `id` bigint(20) NOT NULL,
  `container_id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `quantity_in_stock` float NOT NULL,
  `raw_material_id` bigint(20) NOT NULL,
  `retail_price` float NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `wholesale_price` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `rate`
--

INSERT INTO `rate` (`id`, `container_id`, `create_date`, `quantity_in_stock`, `raw_material_id`, `retail_price`, `update_date`, `wholesale_price`) VALUES
(1, 1, '2020-02-06 00:00:00', 10, 1, 45, '2020-02-06 00:00:00', 50),
(2, 1, '2020-02-06 00:00:00', 10, 2, 45, '2020-02-06 00:00:00', 50);

-- --------------------------------------------------------

--
-- Структура таблицы `raw_material`
--

CREATE TABLE `raw_material` (
  `id` bigint(20) NOT NULL,
  `amount_in_block` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `subcategory_id` bigint(20) NOT NULL,
  `unit_id` bigint(20) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `volume` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `raw_material`
--

INSERT INTO `raw_material` (`id`, `amount_in_block`, `create_date`, `description`, `name`, `subcategory_id`, `unit_id`, `update_date`, `volume`) VALUES
(1, 10, '2020-02-06 00:00:00', 'КОЛА', 'КОЛА', 1, 1, '2020-02-06 00:00:00', 10),
(2, 10, '2020-02-06 00:00:00', 'ПЕПСИ', 'Пепси', 2, 1, '2020-02-06 00:00:00', 10);

-- --------------------------------------------------------

--
-- Структура таблицы `review`
--

CREATE TABLE `review` (
  `id` bigint(20) NOT NULL,
  `container_id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `role_type`
--

CREATE TABLE `role_type` (
  `id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `role_type`
--

INSERT INTO `role_type` (`id`, `created`, `name`, `status`, `updated`) VALUES
(1, '2020-02-18 00:00:00', 'USER_ROLE', 'ACTIVE', '2020-02-11 00:00:00'),
(2, '2020-02-18 00:00:00', 'ADMIN_ROLE', 'ACTIVE', '2020-02-11 00:00:00');

-- --------------------------------------------------------

--
-- Структура таблицы `sale`
--

CREATE TABLE `sale` (
  `id` bigint(20) NOT NULL,
  `count` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `rate_id` bigint(20) NOT NULL,
  `summ` float NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `orders_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `sale`
--

INSERT INTO `sale` (`id`, `count`, `create_date`, `rate_id`, `summ`, `update_date`, `orders_id`) VALUES
(8, 100, '2020-02-15 12:48:25', 1, 350, '2020-02-15 12:48:25', 8),
(9, 100, '2020-02-15 12:49:20', 1, 350, '2020-02-15 12:49:20', 8),
(10, 100, '2020-02-15 12:49:23', 1, 350, '2020-02-15 12:49:23', 8),
(11, 100, '2020-02-15 12:49:25', 1, 350, '2020-02-15 12:49:25', 8),
(12, 100, '2020-02-15 12:49:26', 1, 350, '2020-02-15 12:49:26', 8);

-- --------------------------------------------------------

--
-- Структура таблицы `subcategory`
--

CREATE TABLE `subcategory` (
  `id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `subcategory`
--

INSERT INTO `subcategory` (`id`, `category_id`, `create_date`, `name`, `update_date`) VALUES
(1, 1, '2020-02-06 00:00:00', 'Кола', '2020-02-06 00:00:00'),
(2, 1, '2020-02-06 00:00:00', 'Пепси', '2020-02-06 00:00:00'),
(3, 1, '2020-02-14 11:02:24', 'Фанта', '2020-02-14 11:03:00');

-- --------------------------------------------------------

--
-- Структура таблицы `supplier`
--

CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `unit`
--

CREATE TABLE `unit` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `unit`
--

INSERT INTO `unit` (`id`, `create_date`, `name`, `update_date`) VALUES
(1, '2020-02-05 00:00:00', 'кг', '2020-02-05 00:00:00');

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `patronymic` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telephon_number` int(11) NOT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `create_date`, `email`, `first_name`, `last_name`, `password`, `patronymic`, `status`, `telephon_number`, `update_date`) VALUES
(1, '2020-02-19 00:00:00', 'atai@gmail.com', 'regingMan', 'seitbek', '$2a$04$qvlSLHlGLJks8XzrfgVgZ.Or1WdPNIPzMuZ6MtB0pT5/.4eaLKVam', 'uulu', 'ACTIVE', 700604503, '2020-02-27 00:00:00'),
(2, '2020-02-19 00:00:00', 'uler@gmail.com', 'Ular', 'Luel', '$2a$04$qvlSLHlGLJks8XzrfgVgZ.Or1WdPNIPzMuZ6MtB0pT5/.4eaLKVam', 'uulu', 'ACTIVE', 54645, '2020-02-27 00:00:00');

-- --------------------------------------------------------

--
-- Структура таблицы `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `budget`
--
ALTER TABLE `budget`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `container`
--
ALTER TABLE `container`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjtdol4umavp4t0g6upx7e8d9v` (`budget_id`),
  ADD KEY `FK5corg8rvfnerm0doc61rqfwyu` (`container_category_id`);

--
-- Индексы таблицы `container_category`
--
ALTER TABLE `container_category`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `customer_discount`
--
ALTER TABLE `customer_discount`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7k3ldyceeyaq7fbbt5ky3u5sv` (`discount_id`),
  ADD KEY `FKk85ynpgcsbb2kk50okcrafxwo` (`client_id`);

--
-- Индексы таблицы `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqh0h1vghowobj30yu1mmffpcu` (`container_id`);

--
-- Индексы таблицы `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoao6kc300du888tefrd0v83pk` (`container_id`),
  ADD KEY `FK3046kvjyysq288vy3lsbtc9nw` (`role_id`),
  ADD KEY `FK6lk0xml9r7okjdq0onka4ytju` (`user_id`);

--
-- Индексы таблицы `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7mwuqdvd5g23dbheiie0uwf4k` (`container_id`),
  ADD KEY `FKeh4pjsr2lfvgq6426k81jxsxp` (`orders_status_id`),
  ADD KEY `FKqjej6f6f4lfkvn81oyg60aieu` (`client_id`);

--
-- Индексы таблицы `order_status`
--
ALTER TABLE `order_status`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa7ry1qf6q63mb8lp7dsa6a8mo` (`raw_material_id`),
  ADD KEY `FKy3opx646qpavda3uo1i83ef1` (`container_id`),
  ADD KEY `FKpuc87sx1386rn4yhq0hcuxwfr` (`rate_id`);

--
-- Индексы таблицы `rate`
--
ALTER TABLE `rate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1f89vpc29m7w0ylxkiby9690b` (`container_id`),
  ADD KEY `FKb3ox4604xblltp0a0cqpocy45` (`raw_material_id`);

--
-- Индексы таблицы `raw_material`
--
ALTER TABLE `raw_material`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8h5t75evirtejgttnlbgih8fq` (`subcategory_id`),
  ADD KEY `FK76md1orgum015usg3bwsat9wo` (`unit_id`);

--
-- Индексы таблицы `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKaqpfqm1ad25g4yd978ngf50g4` (`container_id`);

--
-- Индексы таблицы `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `role_type`
--
ALTER TABLE `role_type`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3tpakjc0024g8ytccrarcpn4d` (`orders_id`),
  ADD KEY `FKgwl3m6th9fufhaokj01pexd60` (`rate_id`);

--
-- Индексы таблицы `subcategory`
--
ALTER TABLE `subcategory`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe4hdbsmrx9bs9gpj1fh4mg0ku` (`category_id`);

--
-- Индексы таблицы `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `unit`
--
ALTER TABLE `unit`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_roles`
--
ALTER TABLE `user_roles`
  ADD KEY `FK8e1vce3w6he65gsejy0eis05j` (`role_id`),
  ADD KEY `FK55itppkw3i07do3h7qoclqd4k` (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `budget`
--
ALTER TABLE `budget`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `client`
--
ALTER TABLE `client`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `container`
--
ALTER TABLE `container`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT для таблицы `container_category`
--
ALTER TABLE `container_category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `customer_discount`
--
ALTER TABLE `customer_discount`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `discount`
--
ALTER TABLE `discount`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `employee`
--
ALTER TABLE `employee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `orders`
--
ALTER TABLE `orders`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT для таблицы `order_status`
--
ALTER TABLE `order_status`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `purchase`
--
ALTER TABLE `purchase`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `rate`
--
ALTER TABLE `rate`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `raw_material`
--
ALTER TABLE `raw_material`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `review`
--
ALTER TABLE `review`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `role_type`
--
ALTER TABLE `role_type`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `sale`
--
ALTER TABLE `sale`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT для таблицы `subcategory`
--
ALTER TABLE `subcategory`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `unit`
--
ALTER TABLE `unit`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
