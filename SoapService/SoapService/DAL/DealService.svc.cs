using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.Data.Entity;
using SoapService.Interfaces;
using SoapService.Contexts;
using SoapService.EntityClasses;
using static SoapService.Enums.Enums;
using SoapService.EnumsAndConstants;

namespace SoapService.DAL
{
    [ServiceBehavior(Namespace = Constants.BindingNamespaceDeal)]
    public class DealService : IDealService
    {
        LogDbContext LogContext;
        ServiceDbContext ServiceContext;

        public DealService()
        {
            LogContext = new LogDbContext("LogDbContext");
            ServiceContext = new ServiceDbContext("ServiceDbContext");
        }

        void OnAction(DebugLevel level, string comment, string location, string stack, DateTime time)
        {
            LogContext.Logs.Add(new Log(level, comment, time, location, stack));
            LogContext.SaveChanges();
        }

        public void AddDeal(Deal newdeal)
        {
            try
            {
                ServiceContext.Deals.Add(newdeal);
                ServiceContext.SaveChanges();
                OnAction(DebugLevel.Information, string.Format("add {0}", newdeal.GetType()), newdeal.Flat.Region.Name, "", DateTime.Now);
            }

            catch (Exception ex)
            {
                OnAction(DebugLevel.Error, ex.Message, ex.Source, ex.StackTrace, DateTime.Now);
            }
        }

        public Deal GetDeal(int id)
        {
            OnAction(DebugLevel.Information, string.Format("Get deal -- {0}", id), "", "", DateTime.Now);
            return ServiceContext.Deals.Include("Flat").Where(iten => iten.DealID == id).First();
        }

        public List<Deal> GetAllDeals(int recordsCount = -1)
        {
            OnAction(DebugLevel.Information, string.Format("Getting all deals"), "", "", DateTime.Now);
            if (recordsCount > 0)
            {
                return ServiceContext.Deals.Include("Flat").Take(recordsCount).ToList();
            }
            return ServiceContext.Deals.Include("Flat").ToList();
        }

        public void UpdateDeal(Deal deals)
        {
            try
            {
                ServiceContext.Entry(deals).State = EntityState.Modified;
                ServiceContext.SaveChanges();
                OnAction(DebugLevel.Information, string.Format("updating {0}", deals.GetType()), "", "", DateTime.Now);
            }

            catch (Exception ex)
            {
                OnAction(DebugLevel.Error, ex.Message, ex.Source, ex.StackTrace, DateTime.Now);
            }

        }

        public void RemoveDeal(int id)
        {
            Deal dealforRemove = ServiceContext.Deals.Include("Flat").Where(iten => iten.DealID == id).First();
            if (null != dealforRemove)
            {
                ServiceContext.Deals.Remove(dealforRemove);
                ServiceContext.SaveChanges();
                OnAction(DebugLevel.Information, string.Format("Item {0} removed", dealforRemove.GetType()), "", "", DateTime.Now);
            }
            OnAction(DebugLevel.Error, string.Format("Item {0} not removed", dealforRemove.GetType()), "", "", DateTime.Now);
        }

        public List<Deal> GetDealsByPeriod(DateTime from, DateTime to, int count = -1)
        {
            if (count < -1) return new List<Deal>();
            try
            {
                var dealsByPeriod = ServiceContext.Deals.Where(n => n.Date >= from && n.Date <= to);
                if (count == -1)
                    return dealsByPeriod.ToList();
                else
                    return dealsByPeriod.Take(count).ToList();
            }
            catch (Exception e)
            {
                OnAction(DebugLevel.Error, string.Format(""), e.Source, e.StackTrace, DateTime.Now);
                return new List<Deal>();
            }
            
        }
    }
}
