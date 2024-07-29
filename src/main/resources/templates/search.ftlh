<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Results - InScope</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<!-- Header -->
<header class="bg-primary text-white text-center py-3">
    <h1>Search Results</h1>
</header>

<!-- Main Content -->
<main class="container my-4">
    <div id="search-results" class="row">
        <#if products?has_content>
            <#list products as product>
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <#if product.firstAttachment?has_content>
                            <img src="data:${product.firstAttachment.contentType};base64,${product.firstAttachment.content}" class="card-img-top" alt="${product.firstAttachment.name}">
                        </#if>
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">${product.description}</p>
                            <p class="card-text">Price: $${product.price}</p>
                        </div>
                        <a href="/${product.id}" class="btn btn-primary stretched-link">Details</a>
                    </div>
                </div>
            </#list>
        <#else>
            <p>No products found.</p>
        </#if>
    </div>
</main>

<!-- Footer -->
<footer class="bg-secondary text-white text-center py-3">
    <p>&copy; 2024 Online Store. All rights reserved.</p>
</footer>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
