<%-- 
    Document   : View_Application
    Created on : Mar 9, 2024, 5:29:45 PM
    Author     : lecha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Xem Đơn</title>
        <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        /* Chỉ hiển thị tối đa 50 ký tự trong cột thứ 3 */
        td:nth-child(3) {
            max-width: 150px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
    </head>
    <body>
        <header style="background-color: #45a049">
            <h1>Page Title</h1>
    </header>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Application Type</th>
                <th>Content</th>
                <th>Detail</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Data 1</td>
                <td>Data 2</td>
                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</td>
                <td>Data 4</td>
            </tr>
            <!-- Thêm các hàng dữ liệu khác tại đây nếu cần -->
        </tbody>
    </table>
    </body>
</html>

