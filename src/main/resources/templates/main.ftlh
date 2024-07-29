<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,700;1,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/main.css">
</head>
<body>
<header class="mb-0">
    <nav class="navbar navbar-expand-lg sticky-top">
        <div class="container">
            <a class="navbar-brand" href="#"><img src="./images/logo.png" alt="Buildx"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item pe-lg-2 ps-0 me-2">
                        <a class="nav-link" aria-current="page" href="#">About</a>
                    </li>
                    <li class="nav-item pe-lg-2 ps-0 me-2">
                        <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item pe-lg-2 ps-0 me-2">
                        <a class="nav-link" href="#">Project</a>
                    </li>
                    <li class="nav-item pe-lg-2 ps-0 me-2">
                        <a class="nav-link" href="#">Pages</a>
                    </li>
                    <li class="nav-item pe-lg-2 ps-0 me-2">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="./images/slider-pic.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block mb-5 align-text-top pt-0 ">
                <h1 class="fs-1 text-uppercase">We Do Big Things With Big Ideas</h1>
                <p class="fs-5 mb-5 pb-5 px-5 mx-4">Talk To Our Experts and Get Your Dream Home Done. If you dream of designing
                    a new home that takes full advantage  of the unique geography and
                    views of land that you love</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="./images/slider-pic.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block mb-5 align-text-top pt-0 ">

            </div>
        </div>
        <div class="carousel-item">
            <img src="./images/slider-pic.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block mb-5 align-text-top pt-0 ">

            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<div class="ad mb-5">
    <div class="container">
        <p class="py-3">Counsulting And Estimate For Your Project, <a href="" class="me-5">Contact Us Today</a> <a href="#" class="btn ad-btn ms-5 rounded-0 mb-2">Get a Quote</a></p>
    </div>
</div>
<div class="container text-center my-5">
    <h2 class="section-header text-uppercase mb-3 pt-5">Our Services</h2>
    <p class="section-text px-5 mx-5">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Architecto, minus dolore voluptatum omnis qui sed dolores minima doloremque a laudantium? Lorem ipsum dolor sit, amet consectetur adipisicing elit. Accusantium, cumque vitae! Quaerat aspernatur enim est beatae. Veniam laborum accusantium veritatis?</p>
</div>

<div id="product-list" class="row">
    <#if products?has_content>
        <#list products as product>
            <div class="col-sm-6 col-md-4 mb-4">
                <div class="card product-card h-100">
                    <#if product.firstAttachment?has_content>
                        <img src="data:${product.firstAttachment.contentType};base64,${product.firstAttachment.content}" class="card-img-top" alt="${product.firstAttachment.name}">
                    </#if>
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title">${product.name} - ${product.model}</h5>
                        <p class="card-text">Цена: ${product.price}$</p>
                        <a href="/${product.id}" class="btn btn-primary stretched-link product-button mt-auto">Details</a>
                    </div>
                </div>
            </div>
        </#list>
    <#else>
        <p>No products available.</p>
    </#if>
</div>



<div class="bg-light">
    <div class="container">
        <div class="row row-cols-1 row-cols-md-2 g-4 mt-5">
            <div class="col">
                <div class="card border-0 bg-light">
                    <img src="./images/photo-4.jpg" alt="...">
                </div>
            </div>
            <div class="col ps-5">
                <div class="card border-0 ms-5 bg-light">
                    <div class="card-section bg-transparent mb-4">
                        <h4 class="icon-maintext1 ps-5 pt-2 text-uppercase">General Builder</h4>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque, error? Lorem ipsum dolor sit amet consectetur adipisicing elit. Enim, doloremque.</p>
                    </div>
                    <div class="card-section bg-transparent mb-4">
                        <h4 class="icon-maintext2 ps-5 pt-2 text-uppercase">House Extensions</h4>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque, error? Lorem ipsum dolor sit amet consectetur adipisicing elit. Enim, doloremque.</p>
                    </div>
                    <div class="card-section bg-transparent mb-4">
                        <h4 class="icon-maintext3 ps-5 pt-2 text-uppercase">Refubishment</h4>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque, error? Lorem ipsum dolor sit amet consectetur adipisicing elit. Enim, doloremque.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container text-center my-5">
    <h2 class="section-header text-uppercase mb-3 pt-5">Customer Feedback</h2>
    <p class="section-text px-5 mx-5">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Architecto, minus dolore voluptatum omnis qui sed dolores minima doloremque a laudantium? Lorem ipsum dolor sit, amet consectetur adipisicing elit. Accusantium, cumque vitae! Quaerat aspernatur enim est beatae. Veniam laborum accusantium veritatis?</p>
</div>

<div class="container mt-5 mb-5">
    <div class="row row-cols-1 row-cols-md-2 g-4 mx-auto">
        <div class="card mb-3 border-0" style="max-width: 540px;">
            <div class="row g-0">
                <div class="col-md-4">
                    <img src="./images/avatar-1.jpg" class="img-fluid rounded-0" alt="...">
                </div>
                <div class="col-md-8">
                    <div class="card-body bg-light d-flex flex-column h-100">
                        <p class="card-text flex-grow-1">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-sign text-uppercase flex-grow-0 ms-0 me-auto">HouseBuilders - CEO</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="card mb-3 border-0" style="max-width: 540px;">
            <div class="row g-0">
                <div class="col-md-4">
                    <img src="./images/avatar-2.jpg" class="img-fluid rounded-0" alt="...">
                </div>
                <div class="col-md-8">
                    <div class="card-body bg-light d-flex flex-column h-100">
                        <p class="card-text flex-grow-1">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-sign text-uppercase flex-grow-0 ms-0 me-auto">HouseBuilders - CEO</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container my-5">
    <div class="row row-cols-2 row-cols-md-4 g-4 mx-5 mt-5">
        <div class="col">
            <div class="card border-0 mx-4 pt-3 text-center">
                <a href=""><img src="./images/company-1.jpg" class="card-img-top rounded-0" alt="..."></a>
            </div>
        </div>
        <div class="col">
            <div class="card border-0 mx-4 pt-0 text-center">
                <a href=""><img src="./images/company-2.jpg" class="card-img-top rounded-0" alt="..."></a>
            </div>
        </div>
        <div class="col">
            <div class="card border-0 mx-4 pt-0 text-center">
                <a href=""><img src="./images/company-3.jpg" class="card-img-top rounded-0" alt="..."></a>
            </div>
        </div>
        <div class="col">
            <div class="card border-0 mx-4 pt-0 text-center">
                <a href=""><img src="./images/company-4.jpg" class="card-img-top rounded-0" alt="..."></a>
            </div>
        </div>
    </div>
</div>
<footer class="footer mt-5 mb-0 py-1">
    <p class="mt-2 pt-2 ms-5">© Themexpert 2018</p>
</footer>
<script src="../js/bootstrap.bundle.min.js"></script>
</body>
</html>