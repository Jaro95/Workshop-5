document.addEventListener('DOMContentLoaded', function() {
    console.log('Witaj na naszej stronie!');

    // Przykładowa funkcjonalność: zmiana koloru tła po kliknięciu
    const header = document.querySelector('h1');
    header.addEventListener('click', function() {
        document.body.style.backgroundColor = 'rgba(224,224,224,0.47)';
    });
});