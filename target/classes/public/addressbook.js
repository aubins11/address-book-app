$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/addressbook"
    }).then(function(data) {
        data.forEach((buddy) => {
            $('.buddy-id').append(buddy.id);
            $('.buddy-name').append(buddy.name);
            $('.buddy-phoneNumber').append(buddy.phoneNumber);
        })
    });
});