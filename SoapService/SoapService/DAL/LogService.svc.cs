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

namespace SoapService.DAL
{
    [ServiceBehavior]
    public class LogService : ILogService
    {
        LogDbContext LogContext;
        ServiceDbContext ServiceContext;

        public LogService()
        {
            LogContext = new LogDbContext("LogDbContext");
            ServiceContext = new ServiceDbContext("ServiceDbContext");
        }

       
        public IEnumerable<Log> Get()
        {
            DbSet<Log> data = null;
            try
            {
                data = LogContext.Logs;
            }
            catch
            {
                yield break;
            }
            foreach (var log in data ?? Enumerable.Empty<Log>())
            {
                yield return log;
            }
        }
    }
}
