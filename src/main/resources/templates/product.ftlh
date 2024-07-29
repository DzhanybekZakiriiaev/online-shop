<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${product.name} - InScope</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <style>
        .carousel-container {
            border: 2px solid #ccc; /* Frame border */
            border-radius: 10px; /* Rounded corners */
            padding: 10px; /* Space between the border and the carousel */
            background-color: #f8f8f8; /* Background color inside the frame */
        }
        .carousel-item img {
            max-height: 400px; /* Adjust this value as needed */
            object-fit: contain;
            width: 100%;
        }
        .carousel-inner {
            height: 400px; /* Match the max-height of images */
        }
    </style>
</head>
<body>
<!-- Header -->
<header class="bg-primary text-white text-center py-3">
    <h1>${product.name}</h1>
</header>

<!-- Main Content -->
<main class="container my-4">
    <div class="row">
        <div class="col-md-6">
            <div class="carousel-container">
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner" id="carousel-inner">
                        <#list product.attachmentDtos as attachment>
                            <div class="carousel-item <#if attachment?is_first>active</#if>">
                                <img src="data:${attachment.contentType};base64,${attachment.content}" class="d-block w-100" alt="${attachment.name}">
                            </div>
                        </#list>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <h2>${product.name}</h2>
            <p>${product.description}</p>
            <p>Price: $${product.price}</p>
        </div>
    </div>
</main>

<!-- Footer -->
<footer class="bg-secondary text-white text-center py-3">
    <p>&copy; 2024 Online Store. All rights reserved.</p>
</footer>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
