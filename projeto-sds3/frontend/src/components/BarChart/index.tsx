import Chart from 'react-apexcharts';
import { useState, useEffect } from 'react';
import axios from 'axios';
import { BASE_URL } from 'utils/request';
import { SaleSuccess } from '../../types/sale';
import { round } from '../../utils/format';

type SeriesData = {
    name: string;
    data: number[]
}

type ChartData = {
    labels: {
        categories: string[];
    };
    series: SeriesData[]
}

const BarChart = () => {

    const [chartData, setChartData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "",
                data: []
            }
        ]
    })

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/success-by-seller`)
            .then((response) => {
                const data = response.data as SaleSuccess[];
                const myLabels = data.map(x => x.sellerName);
                const mySeries = data.map(x => round(100.0 * x.deals / x.visited, 1));

                /* chartData = { labels: myLabels, series: mySeries} */
                setChartData({
                    labels: {
                        categories: myLabels
                    },
                    series: [
                        {
                            name: "% Success",
                            data: mySeries
                        }
                    ]
                });

                /* console.log(chartData); */
            });

    }, []);

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

 /*   const mockData = {
        labels: {
            categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
        },
        series: [
            {
                name: "% Sucesso",
                data: [43.6, 67.1, 67.7, 45.6, 71.1]
            }
        ]
    };
*/

    /* o tres pontos seria pra incluir mais parâmetros, quando é 1 só existe somente uma chave, se for mais, duas chaves*/
    /* VIDE https://apexcharts.com/docs/react-charts */
    return (
        <Chart
/*            options={{ ...options, xaxis: mockData.labels }} 
            series={mockData.series} */
            options={{ ...options, xaxis: chartData.labels }} 
            series={chartData.series} 
            type="bar"
            height="240"
        />
    );
}

export default BarChart;
