<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- jQuery -->
<script src="${root}plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${root}plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables & Plugins -->
<script src="${root}plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${root}plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="${root}plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="${root}plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="${root}plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="${root}plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<!-- thư viện pdf copy print -->
<script src="${root}plugins/jszip/jszip.min.js"></script>
<script src="${root}plugins/pdfmake/pdfmake.min.js"></script>
<script src="${root}plugins/pdfmake/vfs_fonts.js"></script>
<script src="${root}plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="${root}plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="${root}plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<!-- AdminLTE App -->
<script src="${root}asset/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${root}asset/dist/js/demo.js"></script>
<!-- Page specific script -->
<script src="${root}plugins/chart.js/Chart.min.js"></script>
<script>
    $(function () {
        $("#example1").DataTable({
            "responsive": true, "lengthChange": false, "autoWidth": false,
            "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
        }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
        });
    });
</script>
<script>

    document.querySelectorAll('[data-type="money"]').forEach(item => {

        item.innerHTML = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'vnd'}).format(item.innerHTML);
    })
</script>