/* px-3 é espaçamento horizontal de 3, e py-3 na vertical, tudo via BOOTSTRAP */
/* col-sm-6 usa 6 das doze unidades */

import NavBar from 'components/NavBar/index_lambda';
import Footer from 'components/Footer/index';
import BarChart from 'components/BarChart/index';
import DataTable from 'components/DataTable';
import DonutChart from './components/DonutChart/index';
function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary py-3">Dashboard de Vendas</h1>

        <div className="row px-3">
          <div className="col-sm-6">
            <h5 className="text-center text-secondary">Taxa de sucesso (%)</h5>
            <BarChart />
          </div>

          <div className="col-sm-6">
            <h5 className="text-center text-secondary"> Todas vendas</h5>
            <DonutChart />
          </div>

        </div>

        <div className="py-3">
          <h2 className="text-primary">
            Todas vendas
          </h2>
        </div>

        <DataTable />
      </div>
      <Footer />

    </>
  );
}

export default App;
