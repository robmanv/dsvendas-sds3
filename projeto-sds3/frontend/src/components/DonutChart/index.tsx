import axios from 'axios';
import Chart from 'react-apexcharts';
import { BASE_URL } from '../../utils/request';
import { SaleSum } from '../../types/sale';

/* Criei um tipo para uso somente aqui */
type ChartData = {
    series: number[]
    labels: string[];
}

const DonutChart = () => {
    /* instanciando o objeto/type acima */
    /* FORMA ERRADA, temos que usar os hooks posteriormente, PORQUE NO CICLO DE VIDA, NO AXIOS POR EXEMPLO, VAI CHAMAR VARIAS VEZES SEGUINDO O CICLO DE VIDA DE RENDERIZAÇÃO, ASSIM, USAR HOOKS */
    /* let variavel, const fixo */
    let chartData : ChartData = { labels: [], series: []}

    /* Usei crase, cifrao e chaves para deixar direto, poderia ser com BASE_URL + '/sales/amount-by-seller') */
    axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then((response) => {
            const data = response.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum);

            chartData = { labels: myLabels, series: mySeries}

            console.log(chartData);
        });

 /* const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }
*/
    
    const options = {
        legend: {
            show: true
        }
    }

/* o tres pontos seria pra incluir mais parâmetros, quando é 1 só existe somente uma chave, se for mais, duas chaves*/    
/* VIDE https://apexcharts.com/docs/react-charts */
    return (
        <Chart 
/*          options={{ ...options, labels: mockData.labels}}
            series={mockData.series} */
            options={{ ...options, labels: chartData.labels}}
            series={chartData.series} 
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;
