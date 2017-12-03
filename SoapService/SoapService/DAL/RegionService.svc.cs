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
    [ServiceBehavior(Namespace = Constants.BindingNamespaceRegion)]
    public class RegionService : IRegionService
    {
        LogDbContext LogContext;
        ServiceDbContext ServiceContext;

        public RegionService()
        {
            LogContext = new LogDbContext("LogDbContext");
            ServiceContext = new ServiceDbContext("ServiceDbContext");
        }

        void OnAction(DebugLevel level, string comment, string location, string stack, DateTime time)
        {
            LogContext.Logs.Add(new Log(level, comment, time, location, stack));
            LogContext.SaveChanges();
        }

        public void AddRegion(Region region)
        {
            try
            {
                ServiceContext.Regions.Add(region);
                ServiceContext.SaveChanges();
                OnAction(DebugLevel.Information, "Item" + region.GetType() + " added", "location", "stack", DateTime.Now);
            }

            catch (Exception ex)
            {
                OnAction(DebugLevel.Information, ex.Message, ex.Source, ex.StackTrace, DateTime.Now);
            }
        }

        public Region GetRegion(int id)
        {
            var regionForRemove = ServiceContext.Regions.Find(id);
            if (null != regionForRemove)
            {
                OnAction(DebugLevel.Information, "", "location", "stack", DateTime.Now);
                return ServiceContext.Regions.Find(id);
            }
            else OnAction(DebugLevel.Information, "null object", "location", "stack", DateTime.Now);
            return null;
        }

        public List<Region> GetAllRegions()
        {
            return ServiceContext.Regions.ToList();
        }

        public void UpdateRegion(Region regions)
        {
            try
            {
                ServiceContext.Entry(regions).State = System.Data.Entity.EntityState.Modified;
                ServiceContext.SaveChanges();
            }
            catch (Exception ex)
            {
                OnAction(DebugLevel.Error, ex.Message, ex.Source, ex.StackTrace, DateTime.Now);
            }
        }

        public void RemoveRegion(int id)
        {
            Region regionforRemove = ServiceContext.Regions.Find(id);
            if (null != regionforRemove)
            {
                ServiceContext.Regions.Remove(regionforRemove);
                ServiceContext.SaveChanges();
            }
        }
    }
}
