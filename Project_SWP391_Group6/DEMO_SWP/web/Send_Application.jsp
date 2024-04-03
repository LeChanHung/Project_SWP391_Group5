<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Viết Đơn</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }

            .container {
                max-width: 600px;
                margin: 20px auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                text-align: center;
            }

            .form-group {
                margin-bottom: 20px;
            }

            label {
                font-weight: bold;
            }

            input[type="text"],
            textarea {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            select {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            /* Ẩn mẫu đơn theo loại đơn */
            #leaveForm,
            #resignationForm,
            #transferForm {
                display: none;
            }

        </style>
    </head>
    <body>

        <div class="container">
            <h2>Send an application</h2>
            <form action="sendApplication" method="post" id="mainForm">
                <div class="form-group">
                    <label for="type">Loại Đơn:</label>
                    <select id="type" name="type" onchange="showForm()">
                        <option value="#">Chọn loại đơn</option>
                        <option value="diemdanh">Đơn Xin Điểm Danh</option>
                        <option value="thoihoc">Đơn Xin Thôi Học</option>
                        <option value="baoluu">Đơn Xin Bảo Lưu</option>
                        <option value="nhaphoc">Đơn Xin Nhập Học Lại</option>
                    </select>
                </div>


                <!-- Mẫu đơn: Đơn Xin Điểm Danh -->
                <div id="diemdanhForm" class="form-group">
                    <!--                    <div class="form-group">
                                            <label for="fullname">Họ và Tên:</label>
                                            <input type="text" id="fullname" name="fullname" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Mã số sinh viên:</label>
                                            <input type="text" id="msv" name="msv" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email:</label>
                                            <input type="text" id="email" name="email" required>
                                        </div>-->
                    <label for="leaveReason">Lý Do Xin Điểm Danh:</label>
                    <textarea id="leaveReason" name="content" rows="5" ></textarea>
                </div>


                <!-- Mẫu đơn: Đơn Xin Thôi Học -->
                <div id="thoihocForm" class="form-group">
                    <!--                    <div class="form-group">
                                            <label for="fullname">Họ và Tên:</label>
                                            <input type="text" id="fullname" name="fullname" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Mã số sinh viên:</label>
                                            <input type="text" id="msv" name="msv" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email:</label>
                                            <input type="text" id="email" name="email" required>
                                        </div>-->
                    <label for="resignationReason">Lý Do Xin Thôi Học:</label>
                    <textarea id="resignationReason" name="content" rows="5" ></textarea>
                </div>


                <!-- Mẫu đơn: Đơn Xin Bảo Lưu -->
                <div id="baoluuForm" class="form-group">
                    <!--                    <div class="form-group">
                                            <label for="fullname">Họ và Tên:</label>
                                            <input type="text" id="fullname" name="fullname" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Mã số sinh viên:</label>
                                            <input type="text" id="msv" name="msv" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email:</label>
                                            <input type="text" id="email" name="email" required>
                                        </div>-->
                    <label for="transferReason">Lý Do Xin Bảo Lưu:</label>
                    <textarea id="transferReason" name="content" rows="5" ></textarea>
                </div>

                <!-- Mẫu đơn: Đơn Xin Nhập Học -->
                <div id="nhaphochForm" class="form-group">
                    <!--                    <div class="form-group">
                                            <label for="fullname">Họ và Tên:</label>
                                            <input type="text" id="fullname" name="fullname" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Mã số sinh viên:</label>
                                            <input type="text" id="msv" name="msv" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email:</label>
                                            <input type="text" id="email" name="email" required>
                                        </div>-->
                    <label for="transferReason">Lý Do Xin Nhập Học:</label>
                    <textarea id="transferReason" name="content" rows="5" ></textarea>
                </div>

                <input type="submit" value="Gửi Đơn">
                <p>${msg}</p>
            </form>
        </div>
        <a class="nav-link" href="viewApplication">View Application</a>
        <script>
            document.getElementById("diemdanhForm").style.display = "none";
            document.getElementById("thoihocForm").style.display = "none";
            document.getElementById("baoluuForm").style.display = "none";
            document.getElementById("nhaphochForm").style.display = "none";
            function showForm() {
                var type = document.getElementById("type").value;
                document.getElementById("diemdanhForm").style.display = "none";
                document.getElementById("thoihocForm").style.display = "none";
                document.getElementById("baoluuForm").style.display = "none";
                document.getElementById("nhaphochForm").style.display = "none";

//                document.getElementById("leaveReason").value = "";
//                document.getElementById("resignationReason").value = "";
//                document.getElementById("transferReason").value = "";
//                document.getElementById("enteringReason").value = "";

                if (type === "diemdanh") {
                    document.getElementById("diemdanhForm").style.display = "block";
                    document.getElementById("leaveReason").value = "";
                    document.getElementById("resignationReason").value = "";
                    document.getElementById("transferReason").value = "";
                    document.getElementById("enteringReason").value = "";

                } else if (type === "thoihoc") {
                    document.getElementById("thoihocForm").style.display = "block";
                    document.getElementById("leaveReason").value = "";
                    document.getElementById("resignationReason").value = "";
                    document.getElementById("transferReason").value = "";
                    document.getElementById("enteringReason").value = "";
                } else if (type === "baoluu") {
                    document.getElementById("baoluuForm").style.display = "block";
                    document.getElementById("leaveReason").value = "";
                    document.getElementById("resignationReason").value = "";
                    document.getElementById("transferReason").value = "";
                    document.getElementById("enteringReason").value = "";
                } else if (type === "nhaphoc") {
                    document.getElementById("nhaphochForm").style.display = "block";
                    document.getElementById("leaveReason").value = "";
                    document.getElementById("resignationReason").value = "";
                    document.getElementById("transferReason").value = "";
                    document.getElementById("enteringReason").value = "";
                }
            }
        </script>

    </body>
</html>
