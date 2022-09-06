$(document).ready(function(){

  

  var xValues = [50,60,70,80,90,100,110];
  var yValues = [7,8,8,9,9,9,10,11,14,14,15];
  
  new Chart("myChart", {
    type: "line",
    data: {
      labels: xValues,
      datasets: [{
        fill: false,
        lineTension: 0,
        backgroundColor: "rgba(0,0,255,1)",
        borderColor: "rgba(0,0,255,0.1)",
        data: yValues
      }]
    },
    options: {
      legend: {display: false},
      scales: {
        yAxes: [{ticks: {min: 6, max:16}}],
      }
    }
  });
  ///////////
  var xValues2 = ["Italy", "France", "Spain", "USA", "Argentina"];
  var yValues2 = [55, 49, 44, 24, 15];
  var barColors = ["red", "green","blue","orange","brown"];
  
  new Chart("myChart2", {
    type: "bar",
    data: {
      labels: xValues2,
      datasets: [{
        backgroundColor: barColors,
        data: yValues2
      }]
    },
    options: {
      legend: {display: false},
      title: {
        display: true,
        text: "World Wine Production 2018"
      }
    }
  });
//////////////////////
var xValues = ["Lost Answer","Correct Answer"];
var yValues = [20,80];
var barColors = [
  "#b91d47",
  "#00aba9"
];
var a =document.getElementById('myChart4').getContext('2d')
  Chart.pluginService.register({
  beforeDraw: function(chart) {
    var width = chart.chart.width,
        height = chart.chart.height,
        ctx = a;

    ctx.restore();
    var fontSize = (height /180).toFixed(2);
    ctx.font = fontSize + "em sans-serif";
    ctx.textBaseline = "middle";

    var text = yValues+"%",
        textX = Math.round((width - ctx.measureText(text).width) / 2),
        textY = height / 1.6;

    ctx.fillText(text, textX, textY);
    ctx.save();
  }
});
new Chart("myChart3", {
  type: "pie",
  data: {
    labels: xValues,
    datasets: [{
      backgroundColor: barColors,
      data: yValues
    }]
  },
  options: {
    responsive:true,
    maintainAspectRatio: false,
    title: {
      display: true,
      text: "Questions and Answers ststistics"
    }
  }
});
///////////////////////////////
new Chart("myChart4", {
  type: "doughnut",
  data: {
    labels: xValues,
    datasets: [{
      backgroundColor: barColors,
      data: yValues ,borderWidth:3
    }],
  
  },
  options: {
    responsive:true,
    maintainAspectRatio: false,
    title: {
      display: true,
      text: "Questions and Answers Stats"
    }
    
  }

  })})