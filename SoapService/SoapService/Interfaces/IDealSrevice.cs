using SoapService.EntityClasses;
using SoapService.EnumsAndConstants;
using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace SoapService.Interfaces
{
    [ServiceContract(Namespace = Constants.BindingNamespaceDeal)]
    public interface IDealService
    {
        [OperationContract]
        void AddDeal(Deal newdeal);

        [OperationContract]
        Deal GetDeal(int id);

        [OperationContract]
        List<Deal> GetAllDeals(int recordsCount = -1);

        [OperationContract]
        void UpdateDeal(Deal deals);

        [OperationContract]
        void RemoveDeal(int id);

        [OperationContract]
        List<Deal> GetDealsByPeriod(DateTime from, DateTime to, int recordsCount = -1);
    }
}
