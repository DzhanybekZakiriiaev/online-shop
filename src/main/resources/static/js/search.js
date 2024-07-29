document.getElementById('searchForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const query = document.getElementById('searchInput').value;

    fetch('/products/search', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            pageRequest: {
                pageInfo: {
                    page: 0,
                    limit: 25
                },
                sortInfo: {
                    sortBy: 'ID',
                    sortDirection: 'ASC'
                }
            },
            filterRequest: {
                name: query
            }
        })
    })
        .then(response => response.json())
        .then(data => {
            const resultsDiv = document.getElementById('search-results');
            resultsDiv.innerHTML = '';

            if (data.content && data.content.length > 0) {
                data.content.forEach(product => {
                    const productCard = `
                    <div class="col-md-4 mb-4">
                        <div class="card">
                            ${product.firstAttachment ? `<img src="data:${product.firstAttachment.contentType};base64,${product.firstAttachment.content}" class="card-img-top" alt="${product.firstAttachment.name}">` : ''}
                            <div class="card-body">
                                <h5 class="card-title">${product.name}</h5>
                                <p class="card-text">${product.description}</p>
                                <p class="card-text">Price: $${product.price}</p>
                                <a href="/${product.id}" class="btn btn-primary stretched-link">Details</a>
                            </div>
                        </div>
                    </div>
                `;
                    resultsDiv.insertAdjacentHTML('beforeend', productCard);
                });
            } else {
                resultsDiv.innerHTML = '<p>No products found.</p>';
            }
        })
        .catch(error => console.error('Error:', error));
});
