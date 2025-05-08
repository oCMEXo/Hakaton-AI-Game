# Шаг 1: Построение приложения
FROM node:20 AS build

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл package.json и package-lock.json для установки зависимостей
COPY package.json package-lock.json ./

# Устанавливаем зависимости
RUN npm install

# Копируем исходный код приложения
COPY . .

# Собираем приложение для продакшена
RUN npm run build

# Шаг 2: Используем Nginx для сервировки статических файлов
FROM nginx:alpine AS production

# Копируем собранное приложение из предыдущего шага в корень Nginx
COPY --from=build /app/build /usr/share/nginx/html

# Указываем стандартный конфигурационный файл Nginx
COPY ./nginx.conf /etc/nginx/conf.d/default.conf

# Указываем, на каком порту приложение будет доступно в контейнере
EXPOSE 80

# Запускаем Nginx
CMD ["nginx", "-g", "daemon off;"]