<%-- 
    Document   : edit
    Created on : Mar 12, 2024, 11:22:43 PM
    Author     : Duy Anh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href= "css/edit.css" rel="stylesheet" type="text/css" />
    </head>
    <body>


        <div class="flex items-center min-h-screen bg-gray-100 dark:bg-gray-900">
            <div class="container mx-auto">
                <div class="max-w-md mx-auto my-10 bg-white p-5 rounded-md shadow-sm">
                    <div class="text-center">
                        <h1 class="my-3 text-3xl font-semibold text-black dark:text-gray-200">
                            Edit News
                        </h1>
                        <p class="text-gray-600 dark:text-gray-400">

                        </p>
                    </div>
                    <div class="m-7">
                        
                        <form action="edit" method="POST" id="form">
                            <input type="hidden" readonly name="id" value="${news.newID}" />
                            <input type="checkbox" name="botcheck" id="" style="display: none;" />
                            <div class="mb-6">
                                <label for="name" class="block mb-2 font-medium text-sm text-gray-600 dark:text-gray-400">Title</label>
                                <input value="${news.title}" type="text" name="title" id="name" placeholder="" required class="w-full px-3 py-2 placeholder-gray-300 border border-gray-400 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-500 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                            </div>
                            <div class="mb-6">
                                <label for="email" class="block mb-2 font-medium text-sm text-gray-600 dark:text-gray-400">Date</label>
                                <input value="${news.date}" type="text" name="date" id="email" placeholder="March 30, 2024" required class="w-full px-3 py-2 placeholder-gray-300 border border-gray-400 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-500 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                            </div>
                            <div class="mb-6">
                                <label for="phone" class="text-sm mb-2 font-medium text-gray-600 dark:text-gray-400">Image Address</label>
                                <input value="${news.img}" type="text" name="img" id="phone" placeholder="" required class="w-full px-3 py-2 placeholder-gray-300 border border-gray-400 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-500 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                            </div>
                            <div class="mb-6">
                                <label for="message" class="block mb-2 font-medium text-sm text-gray-600 dark:text-gray-400">Content</label>

                                <textarea  rows="5" name="content" id="message" placeholder="New Content(<200 Chars)" class="w-full px-3 py-2 placeholder-gray-300 border border-gray-400 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-500 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" required>${news.content}</textarea>
                            </div>
                            <div class="mb-6">
                                <button type="submit" class="w-full px-3 py-4 text-white bg-indigo-700 rounded-md focus:bg-indigo-600 focus:outline-none">
                                    Save
                                </button>
                            </div>
                            <p class="text-base text-center text-gray-400" id="result"></p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
