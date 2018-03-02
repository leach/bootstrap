<script type="text/javascript" src="https://cdn.goeasy.io/goeasy.js"></script>
<script type="text/javascript">
    var goEasy = new GoEasy({
        appkey: "BC-7df4a7d1a2b5404e85226cfd28386250"
    });
    goEasy.subscribe({
        channel: "demo_channel",
        onMessage: function (message) {
            if(confirm(message.content)){
                window.location.reload();
            }else{
                window.location.reload();
            }
        }
    });
</script>