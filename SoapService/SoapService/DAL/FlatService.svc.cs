using SoapService.Contexts;
using SoapService.EntityClasses;
using SoapService.EnumsAndConstants;
using SoapService.Interfaces;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using static SoapService.Enums.Enums;

namespace SoapService.DAL
{
    [ServiceBehavior(Namespace = Constants.BindingNamespaceFlat)]
    public class FlatService : IFlatService
    {
        LogDbContext LogContext;
        ServiceDbContext ServiceContext;

        public FlatService()
        {
            LogContext = new LogDbContext("LogDbContext");
            ServiceContext = new ServiceDbContext("ServiceDbContext");
        }

        void OnAction(DebugLevel level, string comment, string location, string stack, DateTime time)
        {
            LogContext.Logs.Add(new Log(level, comment, time, location, stack));
            LogContext.SaveChanges();
        }

        public void AddFlat(Flat newflat)
        {
            try
            {
                ServiceContext.Flats.Add(newflat);
                ServiceContext.SaveChanges();
                OnAction(DebugLevel.Information, string.Format("Getting all deals"), "", "", DateTime.Now);
            }
            catch (Exception ex)
            {
                OnAction(DebugLevel.Error, string.Format("error adding {0}", newflat.GetType()), ex.Source, ex.StackTrace, DateTime.Now);
            }
        }

        public Flat GetFlat(int id)
        {
            OnAction(DebugLevel.Information, string.Format("Getting flat -- {0}", id), "", "", DateTime.Now);
            return ServiceContext.Flats.Include("Region").Where(iten => iten.FlatID == id).FirstOrDefault();
        }

        public List<Flat> GetAllFlats()
        {
            OnAction(DebugLevel.Information, string.Format("Getting all flats"), "", "", DateTime.Now);
            return ServiceContext.Flats.Include("Region").ToList();
        }

        public void UpdateFlat(Flat flats)
        {

            ServiceContext.Entry(flats).State = System.Data.Entity.EntityState.Modified;
            ServiceContext.SaveChanges();
            OnAction(DebugLevel.Information, string.Format("delas updated"), "", "", DateTime.Now);
        }

        public void RemoveFlat(int id)
        {
            Flat flatforRemove = ServiceContext.Flats.Include("Region").Where(iten => iten.FlatID == id).First();
            if (null != flatforRemove)
            {
                ServiceContext.Flats.Remove(flatforRemove);
                ServiceContext.SaveChanges();
                OnAction(DebugLevel.Information, string.Format("removed flat {0}", id), "", "", DateTime.Now);
            }
            OnAction(DebugLevel.Information, string.Format("cant remove flat {0}", id), "", "", DateTime.Now);
        }

        
    }
}
