let allBooks = [
  {
    bookId: 101,
    bookTitle: "Harry Potter 1",
    bookPrice: 250,
    bookPublished: "2001-10-16",
    bookImgUrl: "https://i.thenile.io/r1000/9780545139700.jpg?r=5e8d433943d7d",
    bookAuthor: {
      authorId: 1001,
      authorName: "J.K Rowling",
    },
  },
  {
    bookId: 102,
    bookTitle: "Harry Potter 2",
    bookPrice: 250,
    bookPublished: "2003-10-19",
    bookImgUrl:
      "https://i1.wp.com/geekdad.com/wp-content/uploads/2013/07/hpnc6.jpg?resize=1575%2C2400&ssl=1",
    bookAuthor: {
      authorId: 1001,
      authorName: "J.K Rowling",
    },
  },
  {
    bookId: 103,
    bookTitle: "The God of Small Things",
    bookPrice: 350,
    bookPublished: "2005-06-20",
    bookImgUrl:
      "https://th.bing.com/th/id/OIP.w4Rto_gWtr-7IrJ8w0tnzAAAAA?rs=1&pid=ImgDetMain",
    bookAuthor: {
      authorId: 1002,
      authorName: "Arundhati Roy",
    },
  },
];

let allAuthors = [
  {
    authorId: 1001,
    authorName: "J.K Rowling",
  },
  {
    authorId: 1002,
    authorName: "Arundhati Roy",
  },
];

function loadAllBooks() {
  let content = `<tr>`;
  allBooks.forEach((eachBook) => {
    content += `<td>${eachBook.bookId}</td>`;
    content += `<td><img src="${eachBook.bookImgUrl}" width="60" height="90"></td>`;
    content += `<td>${eachBook.bookTitle}</td>`;
    content += `<td><button type="button" class="btn btn-primary" onclick="loadABook(${eachBook.bookId})">view</button></td>`;
    content += `<td><button type="button" class="btn btn-warning" onclick="updateForm(${eachBook.bookId})">update</button></td>`;
    content += `<td><button type="button" class="btn btn-danger" onclick="deleteBook(${eachBook.bookId})">delete</button></td>`;
    content += `</tr>`;
  });
  document.getElementById("display").innerHTML = content;
}

function loadABook(bookId) {
  book = allBooks.find((eachBook) => bookId === eachBook.bookId);
  let content = `
  
    <div class="card" id="bookCard" style="text-align: center;">
        <div id="image"> <img src="${book.bookImgUrl}" width="200" height="240" style="display: block; margin: 0 auto;"></div>
        <div class="card-title" id="title">${book.bookTitle}</div>
        <div class="card-text" id="price">Book Price: Rs.${book.bookPrice}</div>
        <div class="card-text" id="author">Book author: ${book.bookAuthor.authorName}</div>
        <div class="card-text" id="published">Book Published on ${book.bookPublished}</div>  
        <button class="btn btn-danger" onclick="hideCard()">CLOSE</button>            
    </div>`;
  document.getElementById("view").innerHTML = content;
}

function hideCard() {
  document.getElementById("view").innerHTML = "";
}

function addBookForm() {

    let content = `<div class="card" id="formCard">
            <form id="bookForm">
                <div class="card-body">

                    <div class="form-group">
                        <label for="bookId" class="form-label">Book ID:</label>
                        <input type="number" id="bookId" class="form-control" required><br>
                    </div>
        
                    <div class="form-group">
                        <label for="bookTitle">Book Title:</label>
                        <input type="text" id="bookTitle" class="form-control" required><br>
                    </div>
        
                    <div class="form-group">
                        <label for="bookPrice">Book Price:</label>
                        <input type="number" id="bookPrice" class="form-control" required><br>
                    </div>
        
                    <div class="form-group">
                        <label for="bookPublished">Published Date:</label>
                        <input type="date" id="bookPublished" class="form-control" required><br>
                    </div>
        
                    <div class="form-group">
                        <label for="bookImgUrl">Image URL:</label>
                        <input type="url" id="bookImgUrl" class="form-control" required><br>
                    </div>
        
                    <div class="form-group">
                        <label for="authorName">Author Name:</label>
                        <input type="text" id="authorName" class="form-control" required><br>
                    </div>
        
                    <button type="butto" class="btn btn-success" onClick="addBook()">Add Book</button>
                    <button type="button" class= "btn btn-warning"onclick="clearForm()">Clear</button>
                </div>
                
            </form>
        </div>`;
        document.getElementById("addForm").innerHTML=content;
}

function addBook(){
    const bookId = document.getElementById('bookId').value;
        const bookTitle = document.getElementById('bookTitle').value;
        const bookPrice = document.getElementById('bookPrice').value;
        const bookPublished = document.getElementById('bookPublished').value;
        const bookImgUrl = document.getElementById('bookImgUrl').value;
        const authorName = document.getElementById('authorName').value;
    
        
        let newBook = {
            bookId: parseInt(bookId),
            bookTitle: bookTitle,
            bookPrice: parseFloat(bookPrice),
            bookPublished: bookPublished,
            bookImgUrl: bookImgUrl,
            bookAuthor: {
                authorId: getAuthorId(authorName),
                authorName: authorName,
            },
        };

        allBooks = [...allBooks, newBook]
    
        document.getElementById('addForm').innerHTML="";
        loadAllBooks();
       
}

function getAuthorId(name){
    let author = allAuthors.find((author) => name.toLowerCase()==author.authorName.toLowerCase());
    if(author) return author.authorId;
    else {
        let id = allAuthors.length+1003;
        allAuthors = [...allAuthors, {authorId: id, authorName: name}];
        return id;
    }
    
}

function clearForm() {
    document.getElementById('bookForm').reset(); // Clear the form fields
}

function updateForm(id){
    let book = allBooks.find((book) => book.bookId == id);
    let content = `<div class="card" id="formCard">
            <form id="bookForm">
                <div class="card-body">

                    <div class="form-group">
                        <label for="bookId" class="form-label">Book ID:</label>
                        <input type="number" id="bookId" class="form-control" value="${book.bookId}" required><br>
                    </div>
        
                    <div class="form-group">
                        <label for="bookTitle">Book Title:</label>
                        <input type="text" id="bookTitle" class="form-control" value="${book.bookTitle}" required><br>
                    </div>
        
                    <div class="form-group">
                        <label for="bookPrice">Book Price:</label>
                        <input type="number" id="bookPrice" class="form-control" value="${book.bookPrice}"required><br>
                    </div>
        
                    <div class="form-group">
                        <label for="bookPublished">Published Date:</label>
                        <input type="date" id="bookPublished" class="form-control" value="${book.bookPublished}" required><br>
                    </div>
        
                    <div class="form-group">
                        <label for="bookImgUrl">Image URL:</label>
                        <input type="url" id="bookImgUrl" class="form-control" value="${book.bookImgUrl}"required><br>
                    </div>
        
                    <div class="form-group">
                        <label for="authorName">Author Name:</label>
                        <input type="text" id="authorName" class="form-control" value="${book.bookAuthor.authorName}"required><br>
                    </div>
        
                    <button type="butto" class="btn btn-success" onClick="updateBook(${book.bookId})">Update Book</button>
                    <button type="button" class= "btn btn-warning"onclick="clearForm()">Clear</button>
                </div>
                
            </form>
        </div>`;
        document.getElementById("addForm").innerHTML=content;
        loadAllBooks();
}

function updateBook(id) {
    let book = allBooks.findIndex((book) => book.bookId == id);
    allBooks[book].bookId = document.getElementById('bookId').value;
    allBooks[book].bookTitle = document.getElementById('bookTitle').value;
    allBooks[book].bookPrice = document.getElementById('bookPrice').value;
    allBooks[book].bookPublished = document.getElementById('bookPublished').value;
    allBooks[book].bookImgUrl = document.getElementById('bookImgUrl').value;
    allBooks[book].authorName = document.getElementById('authorName').value;


    document.getElementById('addForm').innerHTML="";
    loadAllBooks();
}

function deleteBook(delBook) {
  allBooks = allBooks.filter((eachBook) => eachBook.bookId != delBook);
  loadAllBooks();
}

function loadAllAuthors() {}
